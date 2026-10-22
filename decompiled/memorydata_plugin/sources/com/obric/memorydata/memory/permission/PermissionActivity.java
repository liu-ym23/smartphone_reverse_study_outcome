package com.obric.memorydata.memory.permission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.activity.GeneratePluginActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J-\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0002\u0010\u0014J\"\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u001c\u0010\u0019\u001a\u00020\u000b2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u000bH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/memory/permission/PermissionActivity;", "Landroid/app/Activity;", "<init>", "()V", "jumpedToSettings", "", "requestedPermissions", "", "", "[Ljava/lang/String;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "requestCode", "", "permissions", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onActivityResult", "resultCode", "data", "Landroid/content/Intent;", "deliverResult", "results", "", "onDestroy", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PermissionActivity extends GeneratePluginActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10338a = null;
    private static volatile Function2<? super Boolean, ? super Map<String, Boolean>, Unit> d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f10339b;
    private String[] c;

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0017\"\u00020\u0005¢\u0006\u0002\u0010\u0018J\u001c\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019J\u000e\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015Je\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172B\u0010\u001c\u001a>\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000b¢\u0006\u0002\u0010\u001dJR\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152B\u0010\u001c\u001a>\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000RL\u0010\n\u001a@\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/memory/permission/PermissionActivity$Companion;", "", "<init>", "()V", "TAG", "", "EXTRA_PERMISSIONS", "REQUEST_CODE", "", "REQUEST_CODE_SETTINGS", "pendingCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "allGranted", "", "results", "", "hasPermissions", "context", "Landroid/content/Context;", "permissions", "", "(Landroid/content/Context;[Ljava/lang/String;)Z", "", "hasCalendarPermissions", "requestPermissions", "callback", "(Landroid/content/Context;[Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "requestCalendarPermissions", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private static final CharSequence a(String r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            return (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.substringAfterLast$default(r3, '.', null, 2, null), CharSequence.class, "com.obric.memorydata.plugin");
        }

        private static final CharSequence a(Pair r6) {
            Intrinsics.checkNotNullParameter(r6, "it");
            return (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.substringAfterLast$default((String) ZeusTransformUtils.preCheckCast(r6.getFirst(), String.class, "com.obric.memorydata.plugin"), '.', null, 2, null) + '=' + ((Boolean) ZeusTransformUtils.preCheckCast(r6.getSecond(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), CharSequence.class, "com.obric.memorydata.plugin");
        }

        public static /* synthetic */ CharSequence lambda$ZKomby6FUDwHXJpx8LMY0VdJj8c(String r0) {
            return a(r0);
        }

        public static /* synthetic */ CharSequence lambda$eKq16VYb8NhjXo_eCtnGKmTRphw(Pair r0) {
            return a(r0);
        }

        public final void a(Context r3, Function2<? super Boolean, ? super Map<String, Boolean>, Unit> r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Function2<? super Boolean, ? super Map<String, Boolean>, Unit> r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "context");
            Intrinsics.checkNotNullParameter(r6, "callback");
            requestPermissions(r5, new String[]{"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"}, r6);
        }

        public final boolean a(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "context");
            boolean r2 = a(r4, new String[]{"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"});
            RunLog.INSTANCE.debug("MeD_PermissionActivity", "hasCalendarPermissions: " + r2);
            return r2;
        }

        public final boolean a(Context r13, String... r14) {
            Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r12, "context");
            Intrinsics.checkNotNullParameter(r14, "permissions");
            Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r14.length), Collection.class, "com.obric.memorydata.plugin");
            int r1 = r14.length;
            boolean r2 = false;
            int r3 = 0;
        L3:
            boolean r4 = true;
            if (r3 >= r1) goto L10;
            String r5 = r14[r3];
            if (ContextCompat.checkSelfPermission(r12, r5) == 0) goto L9;
            r4 = false;
        L9:
            r15.add(TuplesKt.to(r5, Boolean.valueOf(r4)));
            r3 = r3 + 1;
            goto L3
        L10:
            List r16 = (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin");
            Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r17, Collection.class) == true) goto L13;
        L15:
            Iterator r18 = r17.iterator();
        L17:
            if (r18.hasNext() == false) goto L14;
            if (((Boolean) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r18.next(), Pair.class, "com.obric.memorydata.plugin")).getSecond(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L17;
        L20:
            RunLog.INSTANCE.debug("MeD_PermissionActivity", "hasPermissions: allGranted=" + r2 + ", details=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, $$Lambda$PermissionActivity$a$eKq16VYb8NhjXo_eCtnGKmTRphw.INSTANCE, 31, null));
            return r2;
        L14:
            r2 = true;
            goto L20
        L13:
            if (((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L15;
            goto L14
        }

        public final void requestPermissions(Context r13, String[] r14, Function2<? super Boolean, ? super Map<String, Boolean>, Unit> r15) {
            Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
            Function2 r17 = (Function2) ZeusTransformUtils.wrapperContextForParams(r15, Function2.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r16, "context");
            Intrinsics.checkNotNullParameter(r14, "permissions");
            Intrinsics.checkNotNullParameter(r17, "callback");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_PermissionActivity", "requestPermissions: checking " + r14.length + ": " + ArraysKt.joinToString$default(r14, null, null, null, 0, null, $$Lambda$PermissionActivity$a$ZKomby6FUDwHXJpx8LMY0VdJj8c.INSTANCE, 31, null), false, 4, null);
            int r2 = 0;
            if (a(r16, (String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r14, r14.length), String[].class, "com.obric.memorydata.plugin")) == false) goto L10;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_PermissionActivity", "requestPermissions: all already granted", false, 4, null);
            LinkedHashMap r3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r14.length), 16));
            int r0 = r14.length;
        L5:
            if (r2 >= r0) goto L7;
            ((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin")).put(r14[r2], true);
            r2 = r2 + 1;
            goto L5
        L7:
            r17.invoke(true, (Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin"));
            return;
        L10:
            if (PermissionActivity.a() == null) goto L12;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_PermissionActivity", "requestPermissions: overwriting existing pendingCallback", null, 4, null);
        L12:
            PermissionActivity.a(r17);
            Intent r12 = new Intent(r16, PermissionActivity.class);
            r12.putExtra("extra_permissions", r14);
            r12.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            ZeusTransformUtils.startActivity(r16, r12, "com.obric.memorydata.plugin");     // Catch: Exception -> L15
            return;
        L15:
            e = move-exception;
            RunLog.INSTANCE.error("MeD_PermissionActivity", "requestPermissions: failed to start: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            PermissionActivity.a(null);
            LinkedHashMap r18 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r14.length), 16));
            int r19 = r14.length;
        L17:
            if (r2 >= r19) goto L19;
            String r1 = r14[r2];
            Map r4 = (Map) ZeusTransformUtils.preCheckCast(r18, Map.class, "com.obric.memorydata.plugin");
            String r5 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
            r4.put(r1, false);
            r2 = r2 + 1;
            goto L17
        L19:
            r17.invoke(false, (Map) ZeusTransformUtils.preCheckCast(r18, Map.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f10338a = new a(null);
    }

    public PermissionActivity() {
    }

    private static final CharSequence a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.substringAfterLast$default(r3, '.', null, 2, null), CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ Function2 a() {
        return d;
    }

    private final void a(Map<String, Boolean> r6) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        boolean r1 = true;
        if ((!r5.isEmpty()) == false) goto L17;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r5.values(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L7;
    L9:
        Iterator r8 = r7.iterator();
    L11:
        if (r8.hasNext() == false) goto L8;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r8.next(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L11;
        boolean r9 = false;
    L15:
        if (r9 == false) goto L17;
    L31:
        Function2<? super Boolean, ? super Map<String, Boolean>, Unit> r2 = d;     // Catch: Throwable -> L23 Exception -> L25
        if (r2 == null) goto L22;
        r2.invoke(Boolean.valueOf(r1), r5);     // Catch: Throwable -> L23 Exception -> L25
    L22:
        d = null;
        return;
    L25:
        e = move-exception;
        RunLog.INSTANCE.error("MeD_PermissionActivity", "deliverResult: callback error: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        d = null;
        throw th;
    L8:
        r9 = true;
        goto L15
    L7:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L9;
    L17:
        r1 = false;
        goto L31
    }

    public static final /* synthetic */ void a(Function2 r2) {
        d = (Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ CharSequence lambda$ns3TGKDN_QS5YuCwiWvERqd0uPg(String r0) {
        return a(r0);
    }

    public String getPluginPkgName() {
        return "com.obric.memorydata.plugin";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int r8, int r9, Intent r10) {
        super/*android.app.Activity*/.onActivityResult(r8, r9, r10);
        if (r8 != 1002) goto L30;
        this.f10339b = false;
        String[] r11 = this.c;
        if (r11 != null) goto L7;
    L13:
        boolean r0 = true;
    L14:
        if (r0 == false) goto L17;
        a(MapsKt.emptyMap());
        finish();
        return;
    L17:
        LinkedHashMap r1 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r11.length), 16));
        int r2 = r11.length;
        int r3 = 0;
    L19:
        if (r3 >= r2) goto L25;
        String r4 = r11[r3];
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.memorydata.plugin");
        if (ContextCompat.checkSelfPermission((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), r4) != 0) goto L23;
        boolean r6 = true;
    L24:
        r5.put(r4, Boolean.valueOf(r6));
        r3 = r3 + 1;
        goto L19
    L23:
        r6 = false;
        goto L24
    L25:
        a((Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.memorydata.plugin"));
        finish();
        return;
    L7:
        if (r11.length != 0) goto L9;
        boolean r7 = true;
    L10:
        if (r7 == true) goto L13;
        r0 = false;
        goto L14
    L9:
        r7 = false;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle r9) {
        super/*android.app.Activity*/.onCreate(r9);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_PermissionActivity", "onCreate", false, 4, null);
        Intent r10 = getIntent();
        if (r10 == null) goto L5;
        String[] r11 = r10.getStringArrayExtra("extra_permissions");
    L6:
        int r0 = 0;
        if (r11 != null) goto L9;
    L15:
        boolean r3 = true;
    L16:
        if (r3 == false) goto L19;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_PermissionActivity", "onCreate: no permissions in extras", null, 4, null);
        a(MapsKt.emptyMap());
        finish();
        return;
    L19:
        this.c = r11;
        if (f10338a.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), (String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r11, r11.length), String[].class, "com.obric.memorydata.plugin")) == false) goto L26;
        LinkedHashMap r4 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r11.length), 16));
        int r5 = r11.length;
    L22:
        if (r0 >= r5) goto L24;
        ((Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.memorydata.plugin")).put(r11[r0], true);
        r0 = r0 + 1;
        goto L22
    L24:
        a((Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.memorydata.plugin"));
        finish();
        return;
    L26:
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r7 = r11.length;
        int r8 = 0;
    L27:
        if (r8 >= r7) goto L35;
        String r12 = r11[r8];
        if (ContextCompat.checkSelfPermission((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), r12) == 0) goto L31;
        boolean r13 = true;
    L32:
        if (r13 == false) goto L34;
        r6.add(r12);
    L34:
        r8 = r8 + 1;
        goto L27
    L31:
        r13 = false;
        goto L32
    L35:
        ActivityCompat.requestPermissions((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"), (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin"), 1001);
        return;
    L9:
        if (r11.length != 0) goto L11;
        boolean r14 = true;
    L12:
        if (r14 == true) goto L15;
        r3 = false;
        goto L16
    L11:
        r14 = false;
        goto L12
    L5:
        r11 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        super/*android.app.Activity*/.onDestroy();
        if (d != null) goto L5;
        return;
    L5:
        if (this.f10339b == true) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_PermissionActivity", "onDestroy: fallback empty result", null, 4, null);
        a(MapsKt.emptyMap());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onRequestPermissionsResult(int r21, String[] r22, int[] r23) {
        Intrinsics.checkNotNullParameter(r22, "permissions");
        Intrinsics.checkNotNullParameter(r23, "grantResults");
        super/*android.app.Activity*/.onRequestPermissionsResult(r21, r22, r23);
        if (r21 == 1001) goto L6;
        finish();
        return;
    L6:
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        int r4 = r22.length;
        int r7 = 0;
        int r8 = 0;
    L7:
        boolean r9 = true;
        if (r7 >= r4) goto L17;
        String r10 = r22[r7];
        int r11 = r8 + 1;
        Integer r12 = ArraysKt.getOrNull(r23, r8);
        if (r12 != null) goto L13;
    L15:
        r9 = false;
    L16:
        r3.put(r10, Boolean.valueOf(r9));
        r7 = r7 + 1;
        r8 = r11;
        goto L7
    L13:
        if (r12.intValue() != 0) goto L15;
    L17:
        String[] r1 = this.c;
        if (r1 == null) goto L26;
        int r2 = r1.length;
        int r5 = 0;
    L20:
        if (r5 >= r2) goto L26;
        String r13 = r1[r5];
        if (r3.containsKey(r13) == true) goto L24;
        r3.put(r13, true);
    L24:
        r5 = r5 + 1;
    L26:
        if ((!r3.isEmpty()) == false) goto L40;
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r3.values(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L30;
    L32:
        Iterator r14 = r6.iterator();
    L34:
        if (r14.hasNext() == false) goto L31;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r14.next(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L34;
        boolean r15 = false;
    L38:
        if (r15 == false) goto L40;
        boolean r16 = true;
    L41:
        if (r16 == false) goto L44;
    L42:
        a(r3);
        finish();
        return;
    L44:
        Map r17 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r18 = r3.entrySet().iterator();
    L46:
        if (r18.hasNext() == false) goto L56;
        Map.Entry r19 = (Map.Entry) ZeusTransformUtils.preCheckCast(r18.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r20 = (String) ZeusTransformUtils.preCheckCast(r19.getKey(), String.class, "com.obric.memorydata.plugin");
        if (((Boolean) ZeusTransformUtils.preCheckCast(r19.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L50;
    L52:
        boolean r24 = false;
    L53:
        if (r24 == false) goto L46;
        r17.put(r19.getKey(), r19.getValue());
        goto L46
    L50:
        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"), r20) == true) goto L52;
        r24 = true;
        goto L53
    L56:
        if ((!r17.isEmpty()) == false) goto L42;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_PermissionActivity", "permanently denied: " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r17.keySet(), Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, $$Lambda$PermissionActivity$ns3TGKDN_QS5YuCwiWvERqd0uPg.INSTANCE, 31, null), null, 4, null);
        this.f10339b = true;
        if (e.f10347a.a((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"), null, 1002) == true) goto L75;
        this.f10339b = false;
        a(r3);
        finish();
        return;
    L75:
        return;
    L31:
        r15 = true;
        goto L38
    L30:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L32;
    L40:
        r16 = false;
        goto L41
    }
}
