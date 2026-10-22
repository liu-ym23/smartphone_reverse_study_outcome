package com.obric.memorydata.memory.permission;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.FragmentActivity;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.at;
import com.obric.memorydata.utils.ba;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000e\u000fB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0018\u00010\u000bR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/memory/permission/MemoryLocationPermissionRequestHelper;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "onPermissionGranted", "Lkotlin/Function0;", "", "onPermissionDenied", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "currentRequestCallback", "Lcom/obric/memorydata/memory/permission/MemoryLocationPermissionRequestHelper$MemoryLocationPermissionRequestCallback;", "onActivityResumed", "requestLocationPermissions", "MemoryLocationPermissionRequestCallback", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10341a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FragmentActivity f10342b;
    private final Function0<Unit> c;
    private final Function0<Unit> d;
    private b e;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/permission/MemoryLocationPermissionRequestHelper$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0016J\u0018\u0010\f\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/permission/MemoryLocationPermissionRequestHelper$MemoryLocationPermissionRequestCallback;", "Lcom/obric/memorydata/memory/permission/IRequestPermissionCallback;", "<init>", "(Lcom/obric/memorydata/memory/permission/MemoryLocationPermissionRequestHelper;)V", "onResult", "", "allGranted", "", "grantedList", "", "", "deniedList", "getGoSettingPagePermissionParams", "getShowGoSettingPageDialogTitle", "getShowGoSettingPageDialogMessage", "onGoSettingPageFailed", "onGoSettingPage", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private final class b implements com.obric.memorydata.memory.permission.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f10343a;

        public b(c r1) {
            this.f10343a = r1;
        }

        @Override // com.obric.memorydata.memory.permission.a
        public String a() {
            return at.a(ZeusTransformUtils.mapRes(R.string.memory_location_go_setting_page_dialog_title, TypedValues.Custom.S_STRING, "memory_location_go_setting_page_dialog_title"));
        }

        @Override // com.obric.memorydata.memory.permission.a
        public void a(List<String> r7) {
            Intrinsics.checkNotNullParameter((List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin"), "deniedList");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryLocationPermissionRequestHelper", "onGoSettingPage", false, 4, null);
            c.a(this.f10343a, this);
        }

        public void a(boolean r8, List<String> r9, List<String> r10) {
            List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
            List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r11, "grantedList");
            Intrinsics.checkNotNullParameter(r12, "deniedList");
            com.obric.memorydata.memory.permission.b.f10340a.b();
            boolean r13 = com.obric.memorydata.memory.permission.b.f10340a.a();
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryLocationPermissionRequestHelper", "onResult: hasPermission=" + r13, false, 4, null);
            if (r13 == false) goto L5;
            Function0 r7 = c.a(this.f10343a);
        L6:
            r7.invoke();
            return;
        L5:
            ba.a((Context) ZeusTransformUtils.preCheckCast((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(c.b(this.f10343a), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), at.a(ZeusTransformUtils.mapRes(R.string.memory_location_permission_denied, TypedValues.Custom.S_STRING, "memory_location_permission_denied")), 0, 4, null);
            r7 = c.c(this.f10343a);
            goto L6
        }

        @Override // com.obric.memorydata.memory.permission.a
        public String b() {
            return at.a(ZeusTransformUtils.mapRes(R.string.memory_location_go_setting_page_dialog_message, TypedValues.Custom.S_STRING, "memory_location_go_setting_page_dialog_message"));
        }

        @Override // com.obric.memorydata.memory.permission.a
        public String b(List<String> r2) {
            Intrinsics.checkNotNullParameter((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), "deniedList");
            return "android.permission-group.LOCATION";
        }

        @Override // com.obric.memorydata.memory.permission.a
        public void c() {
            c.a(this.f10343a, null);
            c.c(this.f10343a).invoke();
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryLocationPermissionRequestHelper", "location permission request canceled or settings launch failed", false, 4, null);
        }
    }

    static {
        f10341a = new a(null);
    }

    public c(FragmentActivity r3, Function0<Unit> r4, Function0<Unit> r5) {
        FragmentActivity r6 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r3, FragmentActivity.class, "com.obric.memorydata.plugin");
        Function0<Unit> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Function0<Unit> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "activity");
        Intrinsics.checkNotNullParameter(r7, "onPermissionGranted");
        Intrinsics.checkNotNullParameter(r8, "onPermissionDenied");
        this.f10342b = r6;
        this.c = r7;
        this.d = r8;
    }

    public static final /* synthetic */ Function0 a(c r0) {
        return r0.c;
    }

    public static final /* synthetic */ void a(c r0, b r1) {
        r0.e = r1;
    }

    public static final /* synthetic */ FragmentActivity b(c r0) {
        return r0.f10342b;
    }

    public static final /* synthetic */ Function0 c(c r0) {
        return r0.d;
    }

    public final void a() {
        b r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(true, CollectionsKt.emptyList(), CollectionsKt.emptyList());
        this.e = null;
    }

    public final void b() {
        b r0 = new b(this);
        this.e = r0;
        d.f10344a.a(this.f10342b, CollectionsKt.listOf("android.permission.ACCESS_BACKGROUND_LOCATION"), (com.obric.memorydata.memory.permission.a) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.memory.permission.a.class, "com.obric.memorydata.plugin"));
    }
}
