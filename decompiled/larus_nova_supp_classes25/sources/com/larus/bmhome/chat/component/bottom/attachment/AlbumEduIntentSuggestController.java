package com.larus.bmhome.chat.component.bottom.attachment;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.LruCache;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.camera.api.IFlowCamera;
import com.larus.camera.api.vlm.VLMFileDataType;
import com.larus.camera.api.vlm.VLMIntentScene;
import com.larus.camera.api.vlm.VLMIntentTrackSource;
import com.larus.platform.api.FlowDriveFileType;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.action.SuggestedActionKey;
import com.larus.platform.model.action.SuggestedActionScene;
import com.larus.platform.service.FlowDriveSdkService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class AlbumEduIntentSuggestController {
    public static final LruCache<String, ix8.d> h = null;
    public static String i;
    public static a.C0042a j;
    public static final CoroutineScope k = null;
    public final CoroutineScope a;
    public final Function0<bc8.a> b;
    public final Function0<g> c;
    public final Context d;
    public Job e;
    public String f;
    public b g;

    public static final class a {

        /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.attachment.AlbumEduIntentSuggestController$a$a, reason: collision with other inner class name */
        public static final class C0042a {
            public final Deferred<ix8.d> a;
            public int b;

            public C0042a(Deferred r2) {
                Intrinsics.checkNotNullParameter(r2, "deferred");
                this.a = r2;
                this.b = 1;
            }
        }
    }

    public static final class b {
        public final String a;
        public final Map<String, String> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "RenderedSolveQuestionExt(firstImageKey=" + this.a + ", messageExt=" + this.b + ')';
        }

        public b(String r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r2, "firstImageKey");
            Intrinsics.checkNotNullParameter(r3, "messageExt");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
        h = new LruCache(DoraCallStateCode.DORA_OB_USER_END);
        k = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
    }

    public final void c() {
        if (this.e == null) goto L5;
    L6:
        FLogger r0 = FLogger.a;
        StringBuilder r2 = new StringBuilder("[clear] cancel active detection, imageId=");
        r2.append(this.f);
        r2.append(", jobActive=");
        Job r3 = this.e;
        boolean r4 = false;
        if (r3 != null) goto L9;
    L11:
        r2.append(r4);
        r0.i("AlbumEduIntentSuggest", r2.toString());
    L12:
        Job r1 = this.e;
        if (r1 == null) goto L15;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L15:
        this.e = null;
        this.f = null;
        this.g = null;
        return;
    L9:
        if (r3.isActive() != true) goto L11;
        r4 = true;
        goto L11
    L5:
        if (this.f == null) goto L12;
        goto L6
    }

    public static boolean f(SuggestedAction r2) {
        if (Intrinsics.areEqual(r2.getSuggestedActionKey(), SuggestedActionKey.EduSolveQuestionAlbum.getValue()) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r2.getSuggestedActionKey(), SuggestedActionKey.EduCorrectionAlbum.getValue()) == true) goto L8;
        return false;
    }

    public static List l(List r2) {
        List r3 = r2;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        String r1 = ((SuggestedAction) r4.next()).getSuggestedActionKey();
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        r0.add(r1);
        goto L4
    L9:
        return r0;
    }

    public final InputStream h(Uri r4) {
        String r0 = r4.getScheme();
        if (r0 == null) goto L21;
        int r1 = r0.hashCode();
        if (r1 == (-368816979)) goto L18;
        if (r1 == 3143036) goto L15;
        if (r1 != 951530617) goto L21;
        if (r0.equals("content") == false) goto L21;
    L32:
        return ContentResolverWrapper.openInputStream(this.d.getContentResolver(), r4);
    L15:
        if (r0.equals("file") == true) goto L32;
    L18:
        if (r0.equals("android.resource") == true) goto L32;
    L21:
        String r2 = r4.getPath();
        if (r2 != null) goto L24;
        r2 = r4.toString();
    L24:
        File r3 = new PolarisFileWrapper(r2);
        if (r3.exists() == true) goto L28;
        r3 = null;
    L28:
        if (r3 == null) goto L31;
        return new PolarisFileInputStreamWrapper(r3);
    L31:
        return null;
    }

    public final String k(g r4) {
        g r0 = (g) this.c.invoke();
        if (r0 != null) goto L7;
        return "current_snapshot_unavailable";
    L7:
        if (Intrinsics.areEqual(r0.a, r4.a) == true) goto L10;
        return "conversation_changed";
    L10:
        if (Intrinsics.areEqual(r0.b, r4.b) == true) goto L13;
        return "first_image_changed";
    L13:
        if (r0.d == r4.d) goto L16;
        return "base_scene_changed";
    L16:
        if (Intrinsics.areEqual(r0.e, r4.e) == true) goto L19;
        return "biz_scene_changed";
    L19:
        if (r0.g == r4.g) goto L21;
        return "draft_state_changed";
    L21:
        return null;
    }

    public final void update(final g r4) {
        Intrinsics.checkNotNullParameter(r4, "snapshot");
        FLogger.a.i("AlbumEduIntentSuggest", "[update] start, " + h.a(r4));
        g(r4, new com.larus.bmhome.chat.component.bottom.attachment.b(this, r4));
    }

    public final void g(final g r8, final Function2<? super List<SuggestedAction>, ? super List<SuggestedAction>, Unit> r9) {
        final bc8.a r1 = (bc8.a) this.b.invoke();
        if (r1 != null) goto L6;
        FLogger.a.w("AlbumEduIntentSuggest", "[loadActions] suggested action ability unavailable, " + h.a(r8));
        return;
    L6:
        FLogger.a.i("AlbumEduIntentSuggest", "[loadActions] request base actions, " + h.a(r8));
        r1.cL(r8.d, r8.e, r8.g, r8.f, new c(r8, r1, r9));
    }

    public final void i(g r10, List<SuggestedAction> r11) {
        String r0 = k(r10);
        if (r0 == null) goto L6;
        FLogger.a.i("AlbumEduIntentSuggest", "[render] ignore stale state, reason=" + r0 + ", " + h.a(r10));
        return;
    L6:
        bc8.a r1 = (bc8.a) this.b.invoke();
        if (r1 != null) goto L10;
        FLogger.a.w("AlbumEduIntentSuggest", "[render] suggested action ability unavailable, " + h.a(r10));
        return;
    L10:
        FLogger.a.i("AlbumEduIntentSuggest", "[render] bind actions, actionKeys=" + l(r11) + ", " + h.a(r10));
        r1.Zv(r10.d, r10.e, r11, r10.g, false);
        m(r10, r11);
        r1.np();
    }

    public final void m(g r8, List<SuggestedAction> r9) {
        Iterator<T> r10 = r9.iterator();
    L3:
        b r1 = null;
        if (r10.hasNext() == false) goto L8;
        Object r0 = r10.next();
        if (Intrinsics.areEqual(((SuggestedAction) r0).getSuggestedActionKey(), SuggestedActionKey.EduSolveQuestionAlbum.getValue()) == false) goto L3;
    L9:
        SuggestedAction r2 = (SuggestedAction) r0;
        if (r2 == null) goto L14;
        Map r3 = r2.getMsgExt();
        if (r3 == null) goto L14;
        String r4 = (String) r3.get("Copilot:hippo:hippo_ext");
    L15:
        if (r4 == null) goto L32;
        String r11 = r8.b;
        String r5 = r4;
        if (z2.a.albumUnifiedAgent() == true) goto L34;
    L31:
        r1 = new b(r11, MapsKt.mapOf(TuplesKt.to("Copilot:hippo:hippo_ext", r5)));
        goto L32
    L34:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L21
        JSONObject r7 = new JSONObject(r4);     // Catch: Throwable -> L21
        JSONObject r12 = new JSONObject(r7.optString("data"));     // Catch: Throwable -> L21
        r12.put("detection_scene_type", 120);     // Catch: Throwable -> L21
        Object r13 = Result.constructor-impl(r7.put("data", r12.toString()).toString());     // Catch: Throwable -> L21
    L23:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L26;
        FLogger.a.e("AlbumEduIntentSuggest", "[freeInputHippoExt] rewrite detection_scene_type failed", r14);
    L26:
        Object r15 = r4;
        if (Result.isFailure-impl(r13) == true) goto L30;
        r15 = r13;
    L30:
        r5 = (String) r15;
    L21:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
    L32:
        this.g = r1;
        return;
    L14:
        r4 = null;
        goto L15
    L8:
        r0 = null;
        goto L9
    }

    public static final Object a(AlbumEduIntentSuggestController r20, g r21, Continuation r22) {
        r20.getClass();
        if ((r22 instanceof AlbumEduIntentSuggestController$awaitSharedDetect$1) == false) goto L7;
        AlbumEduIntentSuggestController$awaitSharedDetect$1 r3 = (AlbumEduIntentSuggestController$awaitSharedDetect$1) r22;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        boolean r7 = true;
        if (r6 == 0) goto L18;
        if (r6 != 1) goto L17;
        a.C0042a r1 = (a.C0042a) r3.L$1;
        String r8 = (String) r3.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L14
    L39:
        r5 = (ix8.d) r2;     // Catch: Throwable -> L14
        int r0 = r1.b;
        if (r0 <= 0) goto L43;
        r1.b = r0 - 1;
    L43:
        int r9 = r1.b;
        if (j != r1) goto L46;
        boolean r10 = true;
    L47:
        if (r9 != 0) goto L52;
        if (r10 == false) goto L52;
        i = null;
        j = null;
        if (r1.a.isCompleted() == true) goto L52;
        Job.DefaultImpls.cancel$default(r1.a, null, 1, null);
    L53:
        FLogger.a.i("AlbumEduIntentSuggest", "[awaitSharedDetect] release, remainingSubscribers=" + r9 + ", wasCurrentTask=" + r10 + ", cancelSharedTask=" + r7 + ", imageId=" + r8);
    L54:
        return r5;
    L52:
        r7 = false;
        goto L53
    L46:
        r10 = false;
    L14:
        th = th;
        String r11 = r8;
    L57:
        int r12 = r1.b;
        if (r12 <= 0) goto L60;
        r1.b = r12 - 1;
    L60:
        int r13 = r1.b;
        if (j != r1) goto L63;
        boolean r14 = true;
    L64:
        if (r13 != 0) goto L69;
        if (r14 == false) goto L69;
        i = null;
        j = null;
        if (r1.a.isCompleted() == true) goto L69;
        Job.DefaultImpls.cancel$default(r1.a, null, 1, null);
    L70:
        FLogger.a.i("AlbumEduIntentSuggest", "[awaitSharedDetect] release, remainingSubscribers=" + r13 + ", wasCurrentTask=" + r14 + ", cancelSharedTask=" + r7 + ", imageId=" + r11);
        throw th;
    L69:
        r7 = false;
        goto L70
    L63:
        r14 = false;
        goto L64
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r2);
        r11 = r21.b;
        a.C0042a r15 = j;
        if (Intrinsics.areEqual(i, r11) == false) goto L22;
        if (r15 == null) goto L22;
        r15.b++;
        Pair r16 = TuplesKt.to(r15, Boxing.boxBoolean(false));
    L30:
        r1 = (a.C0042a) r16.component1();
        boolean r17 = ((Boolean) r16.component2()).booleanValue();
        r1.a.start();
        FLogger r18 = FLogger.a;
        StringBuilder r19 = new StringBuilder("[awaitSharedDetect] role=");
        if (r17 == false) goto L33;
        String r23 = "starter";
    L34:
        r19.append(r23);
        r19.append(", subscriberCount=");
        r19.append(r1.b);
        r19.append(", taskActive=");
        r19.append(r1.a.isActive());
        r19.append(", imageId=");
        r19.append(r11);
        r18.i("AlbumEduIntentSuggest", r19.toString());
        Deferred<ix8.d> r24 = r1.a;     // Catch: Throwable -> L56
        r3.L$0 = r11;     // Catch: Throwable -> L56
        r3.L$1 = r1;     // Catch: Throwable -> L56
        r3.label = 1;     // Catch: Throwable -> L56
        Object r25 = r24.await(r3);     // Catch: Throwable -> L56
        if (r25 == r5) goto L54;
        r8 = r11;
        r2 = r25;
    L56:
        th = th;
        goto L57
    L33:
        r23 = "joiner";
    L22:
        if (r15 == null) goto L24;
        FLogger.a.i("AlbumEduIntentSuggest", "[awaitSharedDetect] replace, previousImageId=" + i + ", previousSubscriberCount=" + r15.b + ", previousTaskActive=" + r15.a.isActive() + ", nextImageId=" + r11);
    L24:
        i = null;
        j = null;
        if (r15 == null) goto L29;
        Deferred<ix8.d> r26 = r15.a;
        if (r26 == null) goto L29;
        Job.DefaultImpls.cancel$default(r26, null, 1, null);
    L29:
        a.C0042a r27 = new a.C0042a(BuildersKt.async$default(k, null, CoroutineStart.LAZY, new AlbumEduIntentSuggestController$awaitSharedDetect$newTask$1(r20, r21, r11, null), 1, null));
        i = r11;
        j = r27;
        r16 = TuplesKt.to(r27, Boxing.boxBoolean(true));
    L7:
        r3 = new AlbumEduIntentSuggestController$awaitSharedDetect$1(r20, r22);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v54 */
    /* JADX WARN: Type inference failed for: r0v58 */
    /* JADX WARN: Type inference failed for: r0v59 */
    /* JADX WARN: Type inference failed for: r0v60 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v29 */
    /* JADX WARN: Type inference failed for: r12v36 */
    /* JADX WARN: Type inference failed for: r12v37 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v40 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.graphics.Bitmap, com.larus.bmhome.chat.component.bottom.attachment.g, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10, types: [android.graphics.Bitmap, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v22, types: [oq9.c] */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v30, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33, types: [com.larus.bmhome.chat.component.bottom.attachment.g, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v46 */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARN: Type inference failed for: r1v49 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v50 */
    /* JADX WARN: Type inference failed for: r1v51 */
    /* JADX WARN: Type inference failed for: r1v52 */
    /* JADX WARN: Type inference failed for: r1v53 */
    /* JADX WARN: Type inference failed for: r1v54 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v10, types: [oq9.c] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26, types: [java.lang.Object, oq9.c] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v31, types: [java.lang.Object, oq9.c] */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v13, types: [com.larus.bmhome.chat.component.bottom.attachment.g] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v1, types: [com.larus.bmhome.chat.component.bottom.attachment.g] */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v3, types: [com.larus.bmhome.chat.component.bottom.attachment.g] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [com.larus.bmhome.chat.component.bottom.attachment.g, java.lang.Object] */
    public static final Object b(AlbumEduIntentSuggestController r23, g r24, Continuation r25) {
        ?? r1 = r24;
        r23.getClass();
        if ((r25 instanceof AlbumEduIntentSuggestController$detect$1) == false) goto L7;
        AlbumEduIntentSuggestController$detect$1 r7 = (AlbumEduIntentSuggestController$detect$1) r25;
        int r8 = r7.label;
        if ((r8 & Integer.MIN_VALUE) == 0) goto L7;
        r7.label = r8 - Integer.MIN_VALUE;
    L8:
        ?? r2 = r7.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = r7.label;
        char r12 = 2;
        ?? r13 = 2;
        boolean r14 = true;
        if (r10 != 0) goto L121;
        ResultKt.throwOnFailure(r2);
        r2 = z2.a.getAttachmentAlbumDetectConfig();
        FLogger.a.i("AlbumEduIntentSuggest", "[detect] decode start, source=" + h.b(r1.c) + ", resizeShortSide=" + r2.d() + ", timeoutMs=" + r2.a() + ", compressQuality=" + r2.c() + ", imageId=" + r1.b);
        com.larus.bmhome.chat.component.bottom.attachment.a r11 = r1.c;     // Catch: Exception -> L83 CancellationException -> L107
        if ((r11 instanceof com.larus.bmhome.chat.component.bottom.attachment.a.b) == false) goto L53;
        CoroutineDispatcher r5 = Dispatchers.getIO();     // Catch: Exception -> L83 CancellationException -> L107
        Bitmap r15 = null;
        AlbumEduIntentSuggestController$detect$bitmap$1 r16 = new AlbumEduIntentSuggestController$detect$bitmap$1(r23, r11, r2, null);     // Catch: Exception -> L81 CancellationException -> L111
        r7.L$0 = r1;     // Catch: Exception -> L81 CancellationException -> L111
        r7.L$1 = r2;     // Catch: Exception -> L81 CancellationException -> L111
        r7.label = 1;     // Catch: Exception -> L81 CancellationException -> L111
        Object r0 = BuildersKt.withContext(r5, r16, r7);     // Catch: Exception -> L81 CancellationException -> L111
        ?? r3 = r0;
        ?? r4 = r1;
        ?? r6 = r2;
        if (r0 == r9) goto L122;
    L52:
        Bitmap r17 = (Bitmap) r3;     // Catch: Exception -> L81 CancellationException -> L111
        ?? r18 = r4;
        ?? r19 = r6;
        Bitmap r110 = r15;
    L78:
        ?? r20 = r18;
        ?? r21 = r17;
        ?? r22 = r19;
        r13 = r110;
    L87:
        if (r21 != 0) goto L89;
        FLogger.a.w("AlbumEduIntentSuggest", "[detect] image decode returned null, source=" + h.b(r20.c) + ", imageId=" + r20.b);
        return new ix8.d.a(new ix8.e.b("album image decode failed"));
    L89:
        FLogger r26 = FLogger.a;
        r26.i("AlbumEduIntentSuggest", "[detect] decode success, bitmapWidth=" + r21.getWidth() + ", bitmapHeight=" + r21.getHeight() + ", imageId=" + r20.b);
        IFlowCamera r27 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);     // Catch: Throwable -> L20 Exception -> L100 CancellationException -> L110
        if (r27 != null) goto L93;
        r26.w("AlbumEduIntentSuggest", "[detect] camera service unavailable, imageId=" + r20.b);     // Catch: Throwable -> L20 Exception -> L100 CancellationException -> L110
        ix8.d.a r28 = new ix8.d.a(new ix8.e.b("camera service unavailable"));     // Catch: Throwable -> L20 Exception -> L100 CancellationException -> L110
        ?? r29 = r21;
    L103:
        r29.recycle();
        return r28;
    L93:
        r26.i("AlbumEduIntentSuggest", "[detect] request VLM intent, imageId=" + r20.b);     // Catch: Throwable -> L20 Exception -> L100 CancellationException -> L110
        ix8.c r30 = new ix8.c(CollectionsKt.listOf(new ix8.b(r21, VLMFileDataType.IMAGE)), null, new ix8.a(Boxing.boxLong(r22.a()), r22.d(), r22.c(), true, false, false), VLMIntentTrackSource.ALBUM, 10);     // Catch: Throwable -> L20 Exception -> L100 CancellationException -> L110
        r7.L$0 = r20;     // Catch: Throwable -> L20 Exception -> L100 CancellationException -> L110
        r7.L$1 = r21;     // Catch: Throwable -> L20 Exception -> L100 CancellationException -> L110
        r7.label = 5;     // Catch: Throwable -> L20 Exception -> L100 CancellationException -> L110
        Object r31 = r27.d(r30, r7);     // Catch: Throwable -> L20 Exception -> L100 CancellationException -> L110
        if (r31 == r9) goto L128;
        ?? r32 = r20;
        r21 = r21;
        ?? r33 = r31;
    L97:
        ix8.d.a r34 = (ix8.d) r33;     // Catch: Throwable -> L20 Exception -> L22 CancellationException -> L110
        ?? r35 = r21;
    L98:
        r28 = r34;
        r29 = r35;
    L22:
        Exception e = e;
        r20 = r32;
    L101:
        FLogger.a.e("AlbumEduIntentSuggest", "[detect] request failed, imageId=" + r20.b, e);     // Catch: Throwable -> L20
        r34 = new ix8.d.a(new ix8.e.b(e.getMessage()));     // Catch: Throwable -> L20
        r35 = r21;
        goto L98
    L128:
        return r9;
    L100:
        e = e;
    L106:
        r21.recycle();
        goto L109
    L122:
        return r9;
    L53:
        Bitmap r111 = null;
        Bitmap r112 = null;
        Bitmap r113 = null;
        if ((r11 instanceof com.larus.bmhome.chat.component.bottom.attachment.a.c) == false) goto L59;
        String r36 = ((com.larus.bmhome.chat.component.bottom.attachment.a.c) r11).a;     // Catch: Exception -> L81 CancellationException -> L111
        float r37 = r2.d();     // Catch: Exception -> L81 CancellationException -> L111
        r7.L$0 = r1;     // Catch: Exception -> L81 CancellationException -> L111
        r7.L$1 = r2;     // Catch: Exception -> L81 CancellationException -> L111
        r7.label = 2;     // Catch: Exception -> L81 CancellationException -> L111
        Object r38 = d(r36, r37, r7);     // Catch: Exception -> L81 CancellationException -> L111
        ?? r39 = r38;
        ?? r40 = r1;
        ?? r41 = r2;
        if (r38 == r9) goto L123;
    L58:
        r17 = (Bitmap) r39;     // Catch: Exception -> L81 CancellationException -> L111
        r18 = r40;
        r19 = r41;
        r110 = r112;
        goto L78
    L123:
        return r9;
    L59:
        ?? r42 = r1;
        ?? r43 = r2;
        if ((r11 instanceof com.larus.bmhome.chat.component.bottom.attachment.a.C0043a) == false) goto L76;
        FlowDriveSdkService r44 = FlowDriveSdkService.a;     // Catch: Exception -> L81 CancellationException -> L111
        String r45 = ((com.larus.bmhome.chat.component.bottom.attachment.a.C0043a) r11).a;     // Catch: Exception -> L81 CancellationException -> L111
        FlowDriveFileType r114 = FlowDriveFileType.IMAGE;     // Catch: Exception -> L81 CancellationException -> L111
        r7.L$0 = r1;     // Catch: Exception -> L81 CancellationException -> L111
        r7.L$1 = r2;     // Catch: Exception -> L81 CancellationException -> L111
        r7.label = 3;     // Catch: Exception -> L81 CancellationException -> L111
        Object r46 = r44.i(r45, r114, r7);     // Catch: Exception -> L81 CancellationException -> L111
        ?? r47 = r46;
        ?? r48 = r1;
        ?? r49 = r2;
        if (r46 == r9) goto L124;
    L64:
        String r50 = (String) r47;     // Catch: Exception -> L81 CancellationException -> L111
        if (r50 != null) goto L67;
    L70:
        if (r14 == false) goto L72;
        FLogger.a.w("AlbumEduIntentSuggest", "[detect] drive url unavailable, imageId=" + r48.b);     // Catch: Exception -> L81 CancellationException -> L111
        r42 = r48;
        r43 = r49;
        r111 = r113;
    L77:
        r17 = r111;
        r18 = r42;
        r19 = r43;
        r110 = r111;
        goto L78
    L72:
        float r51 = r49.d();     // Catch: Exception -> L81 CancellationException -> L111
        r7.L$0 = r48;     // Catch: Exception -> L81 CancellationException -> L111
        r7.L$1 = r49;     // Catch: Exception -> L81 CancellationException -> L111
        r7.label = 4;     // Catch: Exception -> L81 CancellationException -> L111
        Object r52 = d(r50, r51, r7);     // Catch: Exception -> L81 CancellationException -> L111
        ?? r53 = r52;
        ?? r54 = r48;
        ?? r55 = r49;
        Bitmap r115 = r113;
        if (r52 == r9) goto L125;
    L75:
        r17 = (Bitmap) r53;     // Catch: Exception -> L81 CancellationException -> L111
        r18 = r54;
        r19 = r55;
        r110 = r115;
        goto L78
    L125:
        return r9;
    L67:
        if (StringsKt.isBlank(r50) == true) goto L70;
        r14 = false;
        goto L70
    L124:
        return r9;
    L76:
        if (r11 == null) goto L77;
        throw new NoWhenBranchMatchedException();     // Catch: Exception -> L81 CancellationException -> L111
    L83:
        e = e;
        r12 = 0;
    L85:
        ?? r56 = r1;
        ?? r57 = r2;
        ?? r116 = r12;
    L86:
        FLogger.a.e("AlbumEduIntentSuggest", "[detect] image decode failed, source=" + h.b(r56.c) + ", imageId=" + r56.b, e);
        r22 = r57;
        r21 = r116;
        r20 = r56;
        r13 = r116;
        goto L87
    L121:
        if (r10 == 1) goto L38;
        if (r10 == 2) goto L35;
        if (r10 != 3) goto L14;
        r1 = (oq9.c) r7.L$1;
        Object r58 = (g) r7.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Exception -> L33 CancellationException -> L107
        r47 = r2;
        r113 = null;
        r49 = r1;
        r48 = r58;
    L33:
        e = e;
    L43:
        r116 = 0;
        r57 = r1;
        r56 = r58;
        goto L86
    L14:
        if (r10 != 4) goto L16;
        oq9.c r59 = (oq9.c) r7.L$1;
        g r60 = (g) r7.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Exception -> L41 CancellationException -> L107
        r53 = r2;
        r115 = null;
        r55 = r59;
        r54 = r60;
        goto L75
    L16:
        if (r10 != 5) goto L26;
        r21 = (Bitmap) r7.L$1;
        r32 = (g) r7.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L20 Exception -> L22 CancellationException -> L24
        r21 = r21;
        r33 = r2;
        r32 = r32;
    L24:
        r13 = 0;
        goto L106
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L35:
        oq9.c r61 = (oq9.c) r7.L$1;
        g r62 = (g) r7.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Exception -> L41 CancellationException -> L107
        r39 = r2;
        r112 = null;
        r41 = r61;
        r40 = r62;
        goto L58
    L38:
        oq9.c r63 = (oq9.c) r7.L$1;
        g r64 = (g) r7.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Exception -> L41 CancellationException -> L107
        r3 = r2;
        r15 = null;
        r6 = r63;
        r4 = r64;
    L41:
        e = e;
        r58 = "[detect] drive url unavailable, imageId=";
    L20:
        th = move-exception;
        r1.recycle();
        throw th;
    L107:
        r13 = 0;
    L81:
        e = e;
    L109:
        return r13;
    L7:
        r7 = new AlbumEduIntentSuggestController$detect$1(r23, r25);
        goto L8
    }

    public static Object d(String r3, float r4, Continuation r5) {
        Float r6 = Boxing.boxFloat(r4);
        if (r6.floatValue() <= 0.0f) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L10;
        r6 = null;
    L10:
        if (r6 == null) goto L12;
        int r7 = (int) r6.floatValue();
    L14:
        return BuildersKt.withContext(Dispatchers.getIO(), new AlbumEduIntentSuggestController$decodeRemoteBitmap$2(r3, r7, null), r5);
    L12:
        r7 = 720;
        goto L14
    L5:
        r0 = false;
        goto L7
    }

    public static SuggestedAction n(SuggestedAction r16, ix8.d r17, int r18) {
        if ((r17 instanceof ix8.d.b) == false) goto L5;
        ix8.d.b r0 = (ix8.d.b) r17;
    L6:
        if (r0 == null) goto L17;
        String r1 = r0.i;
        if (r1 == null) goto L17;
        JSONObject r2 = new JSONObject();
        r2.put("detection_type", 2);
        r2.put("request_id", r1);
        r2.put("edu_camera_sdk_version", "10400");
        r2.put("picture_source", 3);
        r2.put("os", 2);
        r2.put("detection_scene_type", r18);
        r2.put("subject_type", 2);
        JSONObject r3 = new JSONObject();
        r3.put("data", r2.toString());
        r3.put("to_module_unit", new JSONArray().put(new JSONObject().put("to_module", 4)));
        String r4 = r3.toString();
        Map r5 = r16.getMsgExt();
        if (r5 == null) goto L14;
        Map r6 = MapsKt.toMutableMap(r5);
        if (r6 == null) goto L14;
    L15:
        Map r13 = r6;
        r13.put("Copilot:hippo:hippo_ext", r4);
        Unit r7 = Unit.INSTANCE;
        return SuggestedAction.copy$default(r16, null, 0, 0, null, false, null, null, null, null, null, null, r13, 2047, null);
    L14:
        r6 = new LinkedHashMap();
    L17:
        return r16;
    L5:
        r0 = null;
        goto L6
    }

    public final void e(g r7, List<SuggestedAction> r8, Set<String> r9) {
        String r0 = k(r7);
        if (r0 == null) goto L6;
        FLogger.a.i("AlbumEduIntentSuggest", "[insertWithAnimate] ignore stale state, reason=" + r0 + ", " + h.a(r7));
        return;
    L6:
        bc8.a r1 = (bc8.a) this.b.invoke();
        if (r1 != null) goto L10;
        FLogger.a.w("AlbumEduIntentSuggest", "[insertWithAnimate] suggested action ability unavailable, " + h.a(r7));
        return;
    L10:
        FLogger.a.i("AlbumEduIntentSuggest", "[insertWithAnimate] insert actions, actionKeys=" + l(r8) + ", removeActionKeys=" + r9 + ", " + h.a(r7));
        r1.r40(r7.d, r7.e, r8, r9);
        m(r7, r8);
        r1.np();
    }

    public AlbumEduIntentSuggestController(Context r2, LifecycleCoroutineScope r3, c0 r4, d0 r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r4, "suggestedActionAbility");
        Intrinsics.checkNotNullParameter(r5, "currentSnapshot");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r2.getApplicationContext();
    }

    public final void j(g r11, List<SuggestedAction> r12, List<SuggestedAction> r13, ix8.d r14, boolean r15) {
        String r1 = null;
        if ((r14 instanceof ix8.d.b) == false) goto L5;
        ix8.d.b r0 = (ix8.d.b) r14;
    L6:
        if (r0 == null) goto L8;
        String r2 = r0.i;
    L9:
        boolean r3 = false;
        if (r2 != null) goto L12;
    L15:
        boolean r4 = true;
    L16:
        if (r4 == false) goto L18;
        List r5 = CollectionsKt.listOf(VLMIntentScene.COMMON);
    L19:
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r13.iterator();
    L21:
        if (r7.hasNext() == false) goto L46;
        SuggestedAction r8 = (SuggestedAction) r7.next();
        String r9 = r8.getSuggestedActionKey();
        if (Intrinsics.areEqual(r9, SuggestedActionKey.EduSolveQuestionAlbum.getValue()) == false) goto L31;
        if (r5.contains(VLMIntentScene.QUESTION_SOLVING) == true) goto L28;
        r8 = null;
    L28:
        if (r8 == null) goto L43;
        SuggestedAction r10 = n(r8, r14, 110);
    L44:
        if (r10 == null) goto L21;
        r6.add(r10);
    L43:
        r10 = null;
        goto L44
    L31:
        if (Intrinsics.areEqual(r9, SuggestedActionKey.EduCorrectionAlbum.getValue()) == false) goto L43;
        if (r11.d == SuggestedActionScene.AttachmentAreaSingleImg) goto L35;
    L37:
        boolean r16 = false;
    L38:
        if (r16 == true) goto L41;
        r8 = null;
    L41:
        if (r8 == null) goto L43;
        r10 = n(r8, r14, DoraCallStateCode.DOUBAO_CMD_5);
        goto L44
    L35:
        if (r5.contains(VLMIntentScene.HOMEWORK_CORRECTION) == false) goto L37;
        r16 = true;
        goto L38
    L46:
        FLogger r17 = FLogger.a;
        StringBuilder r18 = new StringBuilder("[renderResult] resultType=");
        r18.append(r14.getClass().getSimpleName());
        r18.append(", status=");
        r18.append(r14.b().getClass().getSimpleName());
        r18.append(", hasRequestId=");
        if (r0 == null) goto L49;
        r1 = r0.i;
    L49:
        if (r1 != null) goto L51;
    L52:
        r3 = true;
    L53:
        r18.append(!r3);
        r18.append(", scenes=");
        r18.append(r5);
        r18.append(", animate=");
        r18.append(r15);
        r18.append(", baseActionCount=");
        r18.append(r12.size());
        r18.append(", albumEduActionCount=");
        r18.append(r13.size());
        r18.append(", educationActionKeys=");
        r18.append(l(r6));
        r18.append(", ");
        r18.append(h.a(r11));
        r17.i("AlbumEduIntentSuggest", r18.toString());
        if (r15 == false) goto L56;
        e(r11, r6, SetsKt.setOf(SuggestedActionKey.Loading.getValue()));
        return;
    L56:
        i(r11, CollectionsKt.plus(r6, r12));
        return;
    L51:
        if (StringsKt.isBlank(r1) == false) goto L53;
    L18:
        r5 = ix8.i.a(r14).a;
        goto L19
    L12:
        if (StringsKt.isBlank(r2) == true) goto L15;
        r4 = false;
        goto L16
    L8:
        r2 = null;
        goto L9
    L5:
        r0 = null;
        goto L6
    }
}
