package com.ss.android.lark.chat.service.impl;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.im.v1.GetTenantMessageConfRequest;
import com.bytedance.lark.pb.im.v1.GetTenantMessageConfResponse;
import com.bytedance.lark.pb.im.v1.PushTenantMessageConfResponse;
import com.bytedance.lark.pb.im.v1.TenantMessageConf;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkCall;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkPush;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class MessageTenantConfService extends c38.a<b> implements m6b.j {
    public final MutableLiveData<c> b;

    public static final class a {
    }

    public interface b {
        @SdkCall(4521)
        RucketJob<GetTenantMessageConfResponse> getTenantMessageConf(GetTenantMessageConfRequest r1);

        @SdkPush(4522)
        RucketJob<PushTenantMessageConfResponse> pushTenantMessageConf();
    }

    public static final class c {
        public final long a;
        public final long b;
        public final String c;
        public final boolean d;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof c) == true) goto L8;
            return false;
        L8:
            c r9 = (c) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r9.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r3 = this.b;
            int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
            String r4 = this.c;
            if (r4 != null) goto L5;
            int r5 = 0;
        L6:
            int r6 = (r2 + r5) * 31;
            if (this.d == false) goto L9;
            int r7 = 1231;
        L11:
            return r6 + r7;
        L9:
            r7 = 1237;
            goto L11
        L5:
            r5 = r4.hashCode();
            goto L6
        }

        public final String toString() {
            return "MessageTenantConf(recallEffectiveTime=" + this.a + ", editEffectiveTime=" + this.b + ", inputBoxPlaceHolder=" + this.c + ", isSupportRestrictMessage=" + this.d + ')';
        }

        public c(long r1, long r3, String r5, boolean r6) {
            this.a = r1;
            this.b = r3;
            this.c = r5;
            this.d = r6;
        }
    }

    static {
    }

    @Override // m6b.j
    public final LiveData<c> getConfig() {
        return this.b;
    }

    @Inject
    public MessageTenantConfService(b38.b r9) {
        Intrinsics.checkNotNullParameter(r9, "rucket");
        super(r9);
        this.b = new MutableLiveData(new c(86400, 86400, null, false));
        RucketJob.then$default(((b) ((c38.a) this).a.create(b.class)).pushTenantMessageConf(), null, new MessageTenantConfService$setupPush$1(this, null), 1, null);
    }

    @Override // m6b.j
    public final void jd(boolean r6) {
        if (r6 == false) goto L4;
        SyncDataStrategy r7 = SyncDataStrategy.FORCE_SERVER;
    L5:
        RucketJob.error$default(RucketJob.then$default(((b) ((c38.a) this).a.create(b.class)).getTenantMessageConf(new GetTenantMessageConfRequest.Builder().conf_types(CollectionsKt.mutableListOf(new GetTenantMessageConfRequest.ConfType[]{GetTenantMessageConfRequest.ConfType.EditEffectiveTime, GetTenantMessageConfRequest.ConfType.RecallEffectiveTime, GetTenantMessageConfRequest.ConfType.InputBoxPlaceholder, GetTenantMessageConfRequest.ConfType.IsSupportRestrictMessage})).sync_data_strategy(r7).build()), null, new MessageTenantConfService$fetch$1(this, null), 1, null), null, new MessageTenantConfService$fetch$2(null), 1, null);
        return;
    L4:
        r7 = SyncDataStrategy.LOCAL;
        goto L5
    }

    public static final /* synthetic */ void a(MessageTenantConfService r1, MutableLiveData r2, TenantMessageConf r3) {
        r1.update(r2, r3, true);
    }

    public static /* synthetic */ void b(MessageTenantConfService r1, MutableLiveData r2, TenantMessageConf r3) {
        r1.update(r2, r3, false);
    }

    private final void update(MutableLiveData<c> r9, TenantMessageConf r10, boolean r11) {
        c r7 = new c(r10.recall_effective_time.longValue(), r10.edit_effective_time.longValue(), r10.input_box_placehold, r10.is_support_restrict_message.booleanValue());
        Log.i("MessageTenantConfService", "update message tenant conf " + r7 + " by push: " + r11);
        r9.postValue(r7);
    }
}
