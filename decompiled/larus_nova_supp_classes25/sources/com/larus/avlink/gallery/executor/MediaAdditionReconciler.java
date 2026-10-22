package com.larus.avlink.gallery.executor;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import com.larus.avlink.gallery.business.MediaLifecycleStateManager;
import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.model.MediaLifecycleState;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class MediaAdditionReconciler {
    public static final MediaAdditionReconciler a = null;
    public static final ContentResolver b = null;
    public static final MediaLifecycleStateManager c = null;
    public static final Set<Long> d = null;
    public static final Object e = null;
    public static Job f;
    public static final CoroutineScope g = null;
    public static final ConcurrentHashMap<String, Boolean> h = null;

    public static final class a {
        public final String a;
        public final String b;
        public final String c;
        public final long d;
        public final int e;
        public final int f;
        public final long g;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r9.d) goto L21;
            return false;
        L21:
            if (this.e == r9.e) goto L24;
            return false;
        L24:
            if (this.f == r9.f) goto L27;
            return false;
        L27:
            if (this.g == r9.g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = ((r2 * 31) + this.b.hashCode()) * 31;
            String r4 = this.c;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            int r5 = (r3 + r1) * 31;
            long r6 = this.d;
            int r7 = (((((r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31) + this.e) * 31) + this.f) * 31;
            long r8 = this.g;
            return r7 + ((int) (r8 ^ (r8 >>> 32)));
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "ImageRow(relativePath=" + this.a + ", dataPath=" + this.b + ", displayName=" + this.c + ", size=" + this.d + ", width=" + this.e + ", height=" + this.f + ", createTimeMs=" + this.g + ')';
        }

        public final boolean a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "albumDir");
            if (Build.VERSION.SDK_INT < 29) goto L5;
            com.larus.avlink.gallery.e r3 = com.larus.avlink.gallery.e.a;
            String r0 = this.a;
            r3.getClass();
            return com.larus.avlink.gallery.e.j(r0);
        L5:
            com.larus.avlink.gallery.e r4 = com.larus.avlink.gallery.e.a;
            String r1 = this.b;
            r4.getClass();
            return com.larus.avlink.gallery.e.h(r1);
        }

        public a(String r2, String r3, String r4, long r5, int r7, int r8, long r9) {
            Intrinsics.checkNotNullParameter(r3, "dataPath");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r7;
            this.f = r8;
            this.g = r9;
        }
    }

    public MediaAdditionReconciler() {
    }

    static {
        a = new MediaAdditionReconciler();
        b = AppHost.a.getApplication().getContentResolver();
        c = MediaLifecycleStateManager.b.a();
        d = new LinkedHashSet();
        e = new Object();
        g = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        h = new ConcurrentHashMap();
    }

    public static void j() {
        com.larus.avlink.gallery.e.a.getClass();
        if (com.larus.avlink.gallery.e.i() == true) goto L5;
        return;
    L5:
        String r0 = AccountService.a.getUserId();
        if (r0.length() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r0 = "default";
    L12:
        if (h.putIfAbsent(r0, Boolean.TRUE) == null) goto L14;
        return;
    L14:
        BuildersKt.launch$default(g, null, null, new MediaAdditionReconciler$reconcileAllFromPublicAlbumAsync$1(null), 3, null);
        return;
    L8:
        r1 = false;
        goto L9
    }

    public static a f(long r25) {
        Uri r0 = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r25);
        List r4 = CollectionsKt.mutableListOf(new String[]{"_data", "_display_name", "_size", "width", "height", "date_added"});
        int r5 = Build.VERSION.SDK_INT;
        if (r5 < 29) goto L5;
        r4.add("relative_path");
        r4.add("datetaken");
    L5:
        Ref.ObjectRef r9 = new Ref.ObjectRef();
        Cursor r1 = c(b, r0, (String[]) r4.toArray(new String[0]), null, null);     // Catch: Throwable -> L41 Exception -> L43
        r9.element = r1;     // Catch: Throwable -> L41 Exception -> L43
        if (r1 != null) goto L9;
    L37:
        Cursor r2 = (Cursor) r9.element;
        if (r2 == null) goto L40;
        r2.close();
    L40:
        return null;
    L9:
        if (r1.moveToFirst() == false) goto L37;
        if (r5 < 29) goto L14;
        long r13 = h(r9, "datetaken");     // Catch: Throwable -> L41 Exception -> L43
    L15:
        long r15 = h(r9, "date_added");     // Catch: Throwable -> L41 Exception -> L43
        if (r13 <= 0) goto L19;
    L17:
        long r23 = r13;
        if (r5 < 29) goto L25;
        String r16 = i(r9, "relative_path");     // Catch: Throwable -> L41 Exception -> L43
    L26:
        String r17 = i(r9, "_data");     // Catch: Throwable -> L41 Exception -> L43
        if (r17 != null) goto L32;
        Cursor r3 = (Cursor) r9.element;
        if (r3 == null) goto L31;
        r3.close();
    L31:
        return null;
    L32:
        a r6 = new a(r16, r17, i(r9, "_display_name"), h(r9, "_size"), g(r9, "width"), g(r9, "height"), r23);     // Catch: Throwable -> L41 Exception -> L43
        Cursor r7 = (Cursor) r9.element;
        if (r7 == null) goto L56;
        r7.close();
    L56:
        return r6;
    L25:
        r16 = null;
        goto L26
    L19:
        if (r15 <= 0) goto L21;
        r13 = r15 * ((long) 1000);     // Catch: Throwable -> L41 Exception -> L43
        goto L17
    L21:
        r13 = System.currentTimeMillis();     // Catch: Throwable -> L41 Exception -> L43
        goto L17
    L14:
        r13 = 0;
    L43:
        e = move-exception;
        FLogger.a.w("MediaAdditionReconciler", "Error querying image row " + r25 + ": " + e.getMessage());     // Catch: Throwable -> L41
        Cursor r8 = (Cursor) r9.element;
        if (r8 == null) goto L57;
        r8.close();
        return null;
    L57:
        return null;
    L41:
        th = move-exception;
        Cursor r10 = (Cursor) r9.element;
        if (r10 == null) goto L52;
        r10.close();
    L52:
        throw th;
    }

    public final Object e(Continuation<? super Boolean> r6) {
        if ((r6 instanceof MediaAdditionReconciler$hasInFlightSync$1) == false) goto L7;
        MediaAdditionReconciler$hasInFlightSync$1 r0 = (MediaAdditionReconciler$hasInFlightSync$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r7);
    L25:
        if ((!((Collection) r7).isEmpty()) == true) goto L29;
        r4 = false;
    L29:
        return Boxing.boxBoolean(r4);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r7);
    L20:
        if ((!((Collection) r7).isEmpty()) == true) goto L29;
        MediaLifecycleStateManager r8 = c;
        MediaLifecycleState r5 = MediaLifecycleState.PROCESSED;
        r0.label = 2;
        r8.getClass();
        r7 = MediaLifecycleStateManager.d(r5, r0);
        if (r7 != r2) goto L25;
        return r2;
    L16:
        ResultKt.throwOnFailure(r7);
        MediaLifecycleStateManager r9 = c;
        MediaLifecycleState r10 = MediaLifecycleState.SYNCING_TO_SYSTEM_ALBUM;
        r0.label = 1;
        r9.getClass();
        r7 = MediaLifecycleStateManager.d(r10, r0);
        if (r7 != r2) goto L20;
        return r2;
    L7:
        r0 = new MediaAdditionReconciler$hasInFlightSync$1(this, r6);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v40, types: [com.larus.avlink.gallery.database.AlbumDataBaseHelper] */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v28, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v32, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:114:0x02d2 -> B:116:0x02d5). Please report as a decompilation issue!!! */
    public static final Object b(MediaAdditionReconciler r14, Continuation r15) {
        r14.getClass();
        if ((r15 instanceof MediaAdditionReconciler$reconcileAllFromPublicAlbum$1) == false) goto L7;
        MediaAdditionReconciler$reconcileAllFromPublicAlbum$1 r0 = (MediaAdditionReconciler$reconcileAllFromPublicAlbum$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        Cursor r4 = null;
        switch(r3) {
            case 0: goto L32;
            case 1: goto L31;
            case 2: goto L26;
            case 3: goto L23;
            case 4: goto L20;
            case 5: goto L17;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        long r7 = r0.J$0;
        r3 = r0.I$0;
        Iterator r5 = (Iterator) r0.L$1;
        String r9 = (String) r0.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Exception -> L15 CancellationException -> L124
    L116:
        int r17 = r3 + 1;
        Boxing.boxInt(r3);     // Catch: Exception -> L119 CancellationException -> L124
    L85:
        if (r5.hasNext() == false) goto L130;
        r7 = ((Number) r5.next()).longValue();
        r14.getClass();     // Catch: Exception -> L122 CancellationException -> L124
        a r6 = f(r7);     // Catch: Exception -> L122 CancellationException -> L124
        if (r6 == null) goto L85;
        if (r6.a(r9) == false) goto L85;
        AlbumDataBaseHelper r10 = AlbumDataBaseHelper.a;     // Catch: Exception -> L122 CancellationException -> L124
        List<Long> r11 = CollectionsKt.listOf(Boxing.boxLong(r7));     // Catch: Exception -> L122 CancellationException -> L124
        r0.L$0 = r9;     // Catch: Exception -> L122 CancellationException -> L124
        r0.L$1 = r5;     // Catch: Exception -> L122 CancellationException -> L124
        r0.L$2 = r6;     // Catch: Exception -> L122 CancellationException -> L124
        r0.I$0 = r17;     // Catch: Exception -> L122 CancellationException -> L124
        r0.J$0 = r7;     // Catch: Exception -> L122 CancellationException -> L124
        r0.label = 2;     // Catch: Exception -> L122 CancellationException -> L124
        Object r12 = r10.v(r11, r0);     // Catch: Exception -> L122 CancellationException -> L124
        if (r12 == r2) goto L178;
        r3 = r17;
        r16 = r12;
        String r13 = r9;
        Iterator r18 = r5;
        a r8 = r6;
    L96:
        if ((!((Collection) r16).isEmpty()) == true) goto L121;
        r0.L$0 = r13;     // Catch: Exception -> L29 CancellationException -> L124
        r0.L$1 = r18;     // Catch: Exception -> L29 CancellationException -> L124
        r0.L$2 = r8;     // Catch: Exception -> L29 CancellationException -> L124
        r0.I$0 = r3;     // Catch: Exception -> L29 CancellationException -> L124
        r0.J$0 = r7;     // Catch: Exception -> L29 CancellationException -> L124
        r0.label = 3;     // Catch: Exception -> L29 CancellationException -> L124
        r16 = r14.e(r0);     // Catch: Exception -> L29 CancellationException -> L124
        if (r16 != r2) goto L102;
        return r2;
    L102:
        if (((Boolean) r16).booleanValue() == false) goto L112;
        r0.L$0 = r13;     // Catch: Exception -> L29 CancellationException -> L124
        r0.L$1 = r18;     // Catch: Exception -> L29 CancellationException -> L124
        r0.L$2 = r8;     // Catch: Exception -> L29 CancellationException -> L124
        r0.I$0 = r3;     // Catch: Exception -> L29 CancellationException -> L124
        r0.J$0 = r7;     // Catch: Exception -> L29 CancellationException -> L124
        r0.label = 4;     // Catch: Exception -> L29 CancellationException -> L124
        if (DelayKt.delay(1500, r0) == r2) goto L175;
    L106:
        AlbumDataBaseHelper r19 = AlbumDataBaseHelper.a;     // Catch: Exception -> L29 CancellationException -> L124
        List<Long> r110 = CollectionsKt.listOf(Boxing.boxLong(r7));     // Catch: Exception -> L29 CancellationException -> L124
        r0.L$0 = r13;     // Catch: Exception -> L29 CancellationException -> L124
        r0.L$1 = r18;     // Catch: Exception -> L29 CancellationException -> L124
        r0.L$2 = r8;     // Catch: Exception -> L29 CancellationException -> L124
        r0.I$0 = r3;     // Catch: Exception -> L29 CancellationException -> L124
        r0.J$0 = r7;     // Catch: Exception -> L29 CancellationException -> L124
        r0.label = 5;     // Catch: Exception -> L29 CancellationException -> L124
        r16 = r19.v(r110, r0);     // Catch: Exception -> L29 CancellationException -> L124
        if (r16 != r2) goto L111;
        return r2;
    L111:
        if ((!((Collection) r16).isEmpty()) == false) goto L112;
    L121:
        r17 = r3;
        r5 = r18;
        r9 = r13;
        goto L85
    L175:
        return r2;
    L112:
        a r111 = r8;
        r5 = r18;
        r9 = r13;
        r0.L$0 = r9;     // Catch: Exception -> L15 CancellationException -> L124
        r0.L$1 = r5;     // Catch: Exception -> L15 CancellationException -> L124
        r0.L$2 = null;     // Catch: Exception -> L15 CancellationException -> L124
        r0.I$0 = r3;     // Catch: Exception -> L15 CancellationException -> L124
        r0.J$0 = r7;     // Catch: Exception -> L15 CancellationException -> L124
        r0.label = 6;     // Catch: Exception -> L15 CancellationException -> L124
        if (r14.d(r7, r111, r0) != r2) goto L116;
        return r2;
    L152:
        r17 = r3;
        r5 = r18;
        r9 = r13;
        goto L85
    L178:
        return r2;
    L122:
        e = move-exception;
        r3 = r17;
        e = e;
    L127:
        int r112 = r3;
        Exception r20 = e;
        r17 = r112;
        FLogger.a.e("MediaAdditionReconciler", "Full reconcile: error on " + r7 + ": " + r20.getMessage(), r20);
        goto L85
    L130:
        FLogger.a.i("MediaAdditionReconciler", "=== Full Reconcile Completed: " + r17 + " image(s) registered ===");
        return Unit.INSTANCE;
    L119:
        e = move-exception;
        FLogger.a.e("MediaAdditionReconciler", "Full reconcile: error on " + r7 + ": " + e.getMessage(), e);
    L15:
        e = e;
        goto L127
    L17:
        r7 = r0.J$0;
        r3 = r0.I$0;
        r8 = (a) r0.L$2;
        r18 = (Iterator) r0.L$1;
        r13 = (String) r0.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Exception -> L29 CancellationException -> L124
        goto L111
    L20:
        r7 = r0.J$0;
        r3 = r0.I$0;
        r8 = (a) r0.L$2;
        r18 = (Iterator) r0.L$1;
        r13 = (String) r0.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Exception -> L29 CancellationException -> L124
        goto L106
    L23:
        r7 = r0.J$0;
        r3 = r0.I$0;
        r8 = (a) r0.L$2;
        r18 = (Iterator) r0.L$1;
        r13 = (String) r0.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Exception -> L29 CancellationException -> L124
        goto L102
    L26:
        r7 = r0.J$0;
        r3 = r0.I$0;
        r8 = (a) r0.L$2;
        r18 = (Iterator) r0.L$1;
        r13 = (String) r0.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Exception -> L29 CancellationException -> L124
        goto L96
    L31:
        List r21 = (List) r0.L$1;
        String r22 = (String) r0.L$0;
        ResultKt.throwOnFailure(r16);
        ?? r23 = r21;
    L68:
        ArrayList r24 = new ArrayList();
        Iterator r113 = ((Iterable) r16).iterator();
    L70:
        if (r113.hasNext() == false) goto L74;
        Long r25 = ((MediaMetadata) r113.next()).getSystemGalleryId();
        if (r25 == null) goto L70;
        r24.add(r25);
        goto L70
    L74:
        Set r114 = CollectionsKt.toSet(r24);
        ArrayList r26 = new ArrayList();
        Iterator r27 = ((Iterable) r23).iterator();
    L76:
        if (r27.hasNext() == false) goto L80;
        Object r115 = r27.next();
        if (r114.contains(Boxing.boxLong(((Number) r115).longValue())) == true) goto L76;
        r26.add(r115);
        goto L76
    L80:
        FLogger.a.i("MediaAdditionReconciler", "Full reconcile: disk=" + r23.size() + ", registered=" + r114.size() + ", missing=" + r26.size());
        if (r26.isEmpty() == true) goto L173;
        r5 = r26.iterator();
        r9 = r22;
        r17 = 0;
        goto L85
    L173:
        return Unit.INSTANCE;
    L32:
        ResultKt.throwOnFailure(r16);
        com.larus.avlink.gallery.e.a.getClass();
        r22 = com.larus.avlink.gallery.e.l();
        if (Build.VERSION.SDK_INT < 29) goto L35;
        String[] r28 = {r22 + "/%"};
        String r29 = "relative_path LIKE ?";
    L149:
        Cursor r30 = c(b, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, r29, r28);     // Catch: Throwable -> L54 Exception -> L56
        if (r30 != null) goto L148;
        List r116 = CollectionsKt.emptyList();     // Catch: Throwable -> L54 Exception -> L56
    L44:
        ?? r31 = r116;
    L63:
        if (r31.isEmpty() == false) goto L65;
        FLogger.a.i("MediaAdditionReconciler", "Full reconcile: no image under " + r22);
        return Unit.INSTANCE;
    L65:
        ?? r117 = AlbumDataBaseHelper.a;
        r0.L$0 = r22;
        r0.L$1 = r31;
        r0.label = 1;
        r16 = r117.v(r31, r0);
        r23 = r31;
        if (r16 != r2) goto L68;
        return r2;
    L148:
        int r118 = r30.getColumnIndex("_id");     // Catch: Throwable -> L50 Exception -> L52
        if (r118 >= 0) goto L45;
        r116 = CollectionsKt.emptyList();     // Catch: Throwable -> L50 Exception -> L52
        r30.close();
        goto L44
    L45:
        ?? r32 = new ArrayList();     // Catch: Throwable -> L50 Exception -> L52
    L47:
        if (r30.moveToNext() == false) goto L60;
        r32.add(Long.valueOf(r30.getLong(r118)));     // Catch: Throwable -> L50 Exception -> L52
    L60:
        r30.close();
        ?? r33 = r32;
    L61:
        r31 = r33;
    L52:
        e = e;
    L142:
        FLogger.a.w("MediaAdditionReconciler", "queryAlbumDirImageIds failed: " + e.getMessage());     // Catch: Throwable -> L132
        r32 = CollectionsKt.emptyList();     // Catch: Throwable -> L132
        r33 = r32;
        if (r30 == null) goto L61;
    L132:
        th = th;
        r4 = r30;
    L134:
        r30 = r4;
    L135:
        if (r30 == null) goto L137;
        r30.close();
    L137:
        throw th;
    L50:
        th = th;
    L56:
        e = e;
        r30 = null;
    L54:
        th = th;
        goto L134
    L35:
        r28 = new String[]{"%/" + r22 + "/%"};
        r29 = "_data LIKE ?";
        goto L149
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L29:
        e = e;
        r5 = r18;
        r9 = r13;
    L124:
        e = move-exception;
        throw e;
    L7:
        r0 = new MediaAdditionReconciler$reconcileAllFromPublicAlbum$1(r14, r15);
        goto L8
    }

    public static final int g(Ref.ObjectRef<Cursor> r2, String r3) {
        Integer r4 = Integer.valueOf(((Cursor) r2.element).getColumnIndex(r3));
        if (r4.intValue() < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r4 = null;
    L9:
        if (r4 == null) goto L12;
        int r5 = r4.intValue();
        return ((Cursor) r2.element).getInt(r5);
    L12:
        return 0;
    L5:
        r0 = false;
        goto L6
    }

    public static final long h(Ref.ObjectRef<Cursor> r1, String r2) {
        Integer r3 = Integer.valueOf(((Cursor) r1.element).getColumnIndex(r2));
        if (r3.intValue() < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r3 = null;
    L9:
        if (r3 == null) goto L11;
        int r4 = r3.intValue();
        return ((Cursor) r1.element).getLong(r4);
    L11:
        return 0;
    L5:
        r0 = false;
        goto L6
    }

    public static final String i(Ref.ObjectRef<Cursor> r2, String r3) {
        Integer r4 = Integer.valueOf(((Cursor) r2.element).getColumnIndex(r3));
        if (r4.intValue() < 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L10;
        r4 = null;
    L10:
        if (r4 != null) goto L12;
        return null;
    L12:
        return ((Cursor) r2.element).getString(r4.intValue());
    L5:
        r0 = false;
        goto L7
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x0197 -> B:77:0x0199). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x01d5 -> B:95:0x01f8). Please report as a decompilation issue!!! */
    public static final Object a(MediaAdditionReconciler r21, List r22, Continuation r23) {
        r21.getClass();
        if ((r23 instanceof MediaAdditionReconciler$reconcileAdded$1) == false) goto L7;
        MediaAdditionReconciler$reconcileAdded$1 r1 = (MediaAdditionReconciler$reconcileAdded$1) r23;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
        MediaAdditionReconciler r3 = r21;
    L8:
        Object r0 = r1.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r1.label;
        int r7 = 3;
        int r8 = 2;
        String r10 = "MediaAdditionReconciler";
        if (r5 == 0) goto L36;
        if (r5 == 1) goto L31;
        if (r5 == 2) goto L28;
        if (r5 == 3) goto L25;
        if (r5 == 4) goto L22;
        if (r5 != 5) goto L21;
        long r11 = r1.J$0;
        r5 = r1.I$0;
        Iterator r13 = (Iterator) r1.L$1;
        String r14 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L18
    L77:
        int r9 = r5 + 1;
        Boxing.boxInt(r5);     // Catch: Exception -> L80
        Object r6 = r4;
        int r12 = r9;
        String r15 = r10;
        Iterator r16 = r13;
    L95:
        MediaAdditionReconciler$reconcileAdded$1 r17 = r1;
        String r18 = r14;
    L96:
        r7 = 3;
        r8 = 2;
    L38:
        if (r16.hasNext() == false) goto L97;
        long r19 = ((Number) r16.next()).longValue();
        r3.getClass();     // Catch: Exception -> L90
        a r20 = f(r19);     // Catch: Exception -> L90
        if (r20 == null) goto L96;
        if (r20.a(r18) == false) goto L42;
        AlbumDataBaseHelper r110 = AlbumDataBaseHelper.a;     // Catch: Exception -> L90
        List<Long> r24 = CollectionsKt.listOf(Boxing.boxLong(r19));     // Catch: Exception -> L90
        r17.L$0 = r18;     // Catch: Exception -> L90
        r17.L$1 = r16;     // Catch: Exception -> L90
        r17.L$2 = r20;     // Catch: Exception -> L90
        r17.I$0 = r12;     // Catch: Exception -> L90
        r17.J$0 = r19;     // Catch: Exception -> L90
        r17.label = 1;     // Catch: Exception -> L90
        Object r25 = r110.v(r24, r17);     // Catch: Exception -> L90
    L46:
        if (r25 == r6) goto L120;
        String r111 = r18;
        r1 = r17;
        r4 = r6;
        r5 = r12;
        a r112 = r20;
        r0 = r25;
        Iterator r113 = r16;
        r10 = r15;
        r11 = r19;
    L113:
    L88:
        e = e;
        Object r114 = r4;
        r17 = r1;
        r18 = r111;
        int r115 = r5;
        r6 = r114;
        long r116 = r11;
        r12 = r115;
        r15 = r10;
        r16 = r113;
        r19 = r116;
    L92:
        r111 = r18;
        r1 = r17;
        r4 = r6;
        r5 = r12;
        r113 = r16;
        r10 = r15;
        r11 = r19;
    L93:
        r13 = r113;
        r14 = r111;
    L94:
        FLogger.a.e(r10, "Error reconciling media " + r11 + ": " + e.getMessage(), e);
        r12 = r5;
        r15 = r10;
        r16 = r13;
        r6 = r4;
        goto L95
    L50:
        if ((!((Collection) r0).isEmpty()) == true) goto L86;
        r1.L$0 = r111;     // Catch: Exception -> L88
        r1.L$1 = r113;     // Catch: Exception -> L88
        r1.L$2 = r112;     // Catch: Exception -> L88
        r1.I$0 = r5;     // Catch: Exception -> L88
        r1.J$0 = r11;     // Catch: Exception -> L88
        r1.label = r8;     // Catch: Exception -> L88
        r0 = r3.e(r1);     // Catch: Exception -> L88
        if (r0 == r4) goto L119;
    L107:
        if (((Boolean) r0).booleanValue() == true) goto L105;
    L71:
        r1.L$0 = r111;     // Catch: Exception -> L84
        r1.L$1 = r113;     // Catch: Exception -> L84
        r1.L$2 = null;     // Catch: Exception -> L84
        r1.I$0 = r5;     // Catch: Exception -> L84
        r1.J$0 = r11;     // Catch: Exception -> L84
        r1.label = 5;     // Catch: Exception -> L82
        if (r3.d(r11, r112, r1) == r4) goto L119;
        r13 = r113;
        r14 = r111;
    L82:
        e = e;
        goto L93
    L105:
        r1.L$0 = r111;     // Catch: Exception -> L67
        r1.L$1 = r113;     // Catch: Exception -> L67
        r1.L$2 = r112;     // Catch: Exception -> L67
        r1.I$0 = r5;     // Catch: Exception -> L67
        r1.J$0 = r11;     // Catch: Exception -> L67
        r1.label = r7;     // Catch: Exception -> L67
        if (DelayKt.delay(1500, r1) == r4) goto L119;
    L59:
        AlbumDataBaseHelper r26 = AlbumDataBaseHelper.a;     // Catch: Exception -> L34
        List<Long> r27 = CollectionsKt.listOf(Boxing.boxLong(r11));     // Catch: Exception -> L34
        r1.L$0 = r111;     // Catch: Exception -> L34
        r1.L$1 = r113;     // Catch: Exception -> L34
        r1.L$2 = r112;     // Catch: Exception -> L34
        r1.I$0 = r5;     // Catch: Exception -> L34
        r1.J$0 = r11;     // Catch: Exception -> L34
        r1.label = 4;     // Catch: Exception -> L34
        r0 = r26.v(r27, r1);     // Catch: Exception -> L34
        if (r0 == r4) goto L119;
    L64:
        if ((!((Collection) r0).isEmpty()) == false) goto L71;
        r12 = r5;
        r15 = r10;
        r16 = r113;
        r6 = r4;
        r17 = r1;
        r18 = r111;
    L67:
        e = e;
    L70:
        r13 = r113;
        r14 = r111;
    L84:
        e = e;
    L119:
        return r4;
    L86:
        r12 = r5;
        r15 = r10;
        r16 = r113;
        r6 = r4;
        r17 = r1;
        r18 = r111;
        goto L96
    L120:
        return r6;
    L90:
        e = e;
        goto L92
    L97:
        if (r12 <= 0) goto L100;
        FLogger.a.i(r15, "=== Addition Reconcile Completed: " + r12 + " externally added image(s) registered ===");
    L100:
        return Unit.INSTANCE;
    L80:
        e = e;
        r5 = r9;
    L18:
        e = e;
        goto L94
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L22:
        r11 = r1.J$0;
        r5 = r1.I$0;
        r112 = (a) r1.L$2;
        r113 = (Iterator) r1.L$1;
        r111 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L34
        goto L64
    L25:
        r11 = r1.J$0;
        r5 = r1.I$0;
        r112 = (a) r1.L$2;
        r113 = (Iterator) r1.L$1;
        r111 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L34
        goto L59
    L28:
        r11 = r1.J$0;
        r5 = r1.I$0;
        r112 = (a) r1.L$2;
        r113 = (Iterator) r1.L$1;
        r111 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L34
        goto L107
    L31:
        r11 = r1.J$0;
        r5 = r1.I$0;
        r112 = (a) r1.L$2;
        r113 = (Iterator) r1.L$1;
        r111 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L34
        goto L113
    L36:
        ResultKt.throwOnFailure(r0);
        com.larus.avlink.gallery.e.a.getClass();
        String r28 = com.larus.avlink.gallery.e.l();
        r15 = "MediaAdditionReconciler";
        r12 = 0;
        r16 = r22.iterator();
        r6 = r4;
        r17 = r1;
        r18 = r28;
    L34:
        e = e;
    L7:
        r3 = r21;
        r1 = new MediaAdditionReconciler$reconcileAdded$1(r3, r23);
        goto L8
    }

    public final Object d(long r42, a r44, Continuation<? super Unit> r45) {
        long r0 = r42;
        if ((r45 instanceof MediaAdditionReconciler$createExternalMetadata$1) == false) goto L7;
        MediaAdditionReconciler$createExternalMetadata$1 r3 = (MediaAdditionReconciler$createExternalMetadata$1) r45;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        MediaAdditionReconciler$createExternalMetadata$1 r9 = r3;
        Object r2 = r9.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r9.label;
        boolean r7 = true;
        if (r6 == 0) goto L18;
        if (r6 == 1) goto L17;
        if (r6 == 2) goto L16;
        if (r6 != 3) goto L15;
        String r1 = (String) r9.L$1;
        a r8 = (a) r9.L$0;
        ResultKt.throwOnFailure(r2);
    L52:
        FLogger.a.i("MediaAdditionReconciler", "Registered externally added image: uniqId=" + r1 + ", path=" + r8.b);
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r1 = (String) r9.L$1;
        r8 = (a) r9.L$0;
        ResultKt.throwOnFailure(r2);
    L49:
        MediaLifecycleStateManager r10 = c;
        MediaLifecycleState r11 = MediaLifecycleState.COMPLETED;
        r9.L$0 = r8;
        r9.L$1 = r1;
        r9.label = 3;
        if (MediaLifecycleStateManager.g(r10, r1, r11, null, r9, 4) != r5) goto L52;
        return r5;
    L17:
        r0 = r9.J$0;
        String r12 = (String) r9.L$1;
        a r13 = (a) r9.L$0;
        ResultKt.throwOnFailure(r2);
    L21:
        long r14 = r0;
        a r15 = r13;
        if (r2 != null) goto L24;
        Long r16 = Boxing.boxLong(r14);
        String r17 = r15.c;
        Long r18 = Boxing.boxLong(r15.d);
        Integer r19 = Boxing.boxInt(r15.e);
        if (r19.intValue() <= 0) goto L28;
        boolean r20 = true;
    L29:
        Integer r110 = null;
        if (r20 == true) goto L33;
        r19 = null;
    L33:
        if (r19 == null) goto L35;
        int r111 = r19.intValue();
    L36:
        Integer r21 = Boxing.boxInt(r15.f);
        if (r21.intValue() > 0) goto L40;
        r7 = false;
    L40:
        if (r7 == false) goto L42;
        r110 = r21;
    L42:
        if (r110 == null) goto L44;
        int r112 = r110.intValue();
    L45:
        MediaMetadata r22 = new MediaMetadata(r12, r14, r16, r17, r18, "image", r111, r112, 0, 0, 0, 0.0d, r15.g, null, null, MediaLifecycleState.SYNCING_TO_SYSTEM_ALBUM, null, null, null, null, null, null, r15.b, 0, 12545536, null);
        AlbumDataBaseHelper r23 = AlbumDataBaseHelper.a;
        r9.L$0 = r15;
        r9.L$1 = r12;
        r9.label = 2;
        if (r23.h(r22, r9) != r5) goto L48;
        return r5;
    L48:
        r8 = r15;
        r1 = r12;
        goto L49
    L44:
        r112 = 4032;
        goto L45
    L35:
        r111 = 3024;
        goto L36
    L28:
        r20 = false;
        goto L29
    L24:
        return Unit.INSTANCE;
    L18:
        ResultKt.throwOnFailure(r2);
        r12 = "ext_" + r0;
        AlbumDataBaseHelper r24 = AlbumDataBaseHelper.a;
        r13 = r44;
        r9.L$0 = r13;
        r9.L$1 = r12;
        r9.J$0 = r0;
        r9.label = 1;
        r2 = r24.o(r12, r9);
        if (r2 != r5) goto L21;
        return r5;
    L7:
        r3 = new MediaAdditionReconciler$createExternalMetadata$1(this, r45);
        goto L8
    }

    public static Cursor c(ContentResolver r13, Uri r14, String[] r15, String r16, String[] r17) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r14, r15, r16, r17, null};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", "query", r13, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r12 = r13.query(r14, r15, r16, r17, null);
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, r12, r10, true);
        return r12;
    }
}
