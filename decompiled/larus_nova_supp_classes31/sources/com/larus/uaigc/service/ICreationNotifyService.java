package com.larus.uaigc.service;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.larus.platform.api.creation.UserCreation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015J6\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\fH&J<\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H&J\b\u0010\u0014\u001a\u00020\u0003H&¨\u0006\u0016"}, d2 = {"Lcom/larus/uaigc/service/ICreationNotifyService;", "", "pushCreationNotify", "", "creation", "Lcom/larus/platform/api/creation/UserCreation;", "activity", "Landroid/app/Activity;", "shareContainer", "Landroid/view/View;", "targetActivity", "skipChannel", "", "pushCreationDoSameNotify", "notifyInfo", "Lcom/larus/uaigc/service/CreationDoSameNotifyInfo;", "enterMethod", "", "clickCallBack", "Lkotlin/Function0;", "dismissCreationNotify", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface ICreationNotifyService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J=\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0096\u0001J3\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0096\u0001¨\u0006\u0017"}, d2 = {"Lcom/larus/uaigc/service/ICreationNotifyService$Companion;", "Lcom/larus/uaigc/service/ICreationNotifyService;", "<init>", "()V", "dismissCreationNotify", "", "pushCreationDoSameNotify", "notifyInfo", "Lcom/larus/uaigc/service/CreationDoSameNotifyInfo;", "activity", "Landroid/app/Activity;", "targetActivity", "enterMethod", "", "clickCallBack", "Lkotlin/Function0;", "pushCreationNotify", "creation", "Lcom/larus/platform/api/creation/UserCreation;", "shareContainer", "Landroid/view/View;", "skipChannel", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class Companion implements ICreationNotifyService {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ ICreationNotifyService b;

        static {
            c = new Companion();
        }

        @Override // com.larus.uaigc.service.ICreationNotifyService
        public final void J(UserCreation r8, FragmentActivity r9, View r10, Activity r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r8, "creation");
            Intrinsics.checkNotNullParameter(r9, "activity");
            Intrinsics.checkNotNullParameter(r10, "shareContainer");
            this.b.J(r8, r9, r10, r11, r12);
        }

        @Override // com.larus.uaigc.service.ICreationNotifyService
        public final void K(CreationDoSameNotifyInfo r8, Activity r9, Activity r10, String r11, Function0<Unit> r12) {
            Intrinsics.checkNotNullParameter(r9, "activity");
            Intrinsics.checkNotNullParameter(r12, "clickCallBack");
            this.b.K(r8, r9, r10, r11, r12);
        }

        @Override // com.larus.uaigc.service.ICreationNotifyService
        public final void y() {
            this.b.y();
        }

        private Companion() {
            ICreationNotifyService r0 = (ICreationNotifyService) ServiceManager.get().getService(ICreationNotifyService.class);
            if (r0 != null) goto L5;
            r0 = new ICreationNotifyServiceNoop();
        L5:
            this.b = r0;
        }
    }

    static {
        a = Companion.c;
    }

    void J(UserCreation r1, FragmentActivity r2, View r3, Activity r4, boolean r5);

    void K(CreationDoSameNotifyInfo r1, Activity r2, Activity r3, String r4, Function0<Unit> r5);

    void y();
}
