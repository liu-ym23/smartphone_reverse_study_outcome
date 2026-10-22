package com.bytedance.android.live.revlink.impl.multianchor.dialog;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.common.k;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.live.revlink.scopeui.KmpWidget;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.live.datacontext.m;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import yz0.f;
import yz0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiLinkConfigManager {
    public final CompositeDisposable a;
    public f b;
    public KmpWidget c;
    public final com.bytedance.android.livesdk.revenue.service.room.c d;
    public final com.bytedance.android.live.revlink.impl.global.c e;

    public static final class b<T> implements Consumer {
        public final /* synthetic */ MultiLinkConfigManager a;
        public final /* synthetic */ MultiLinkConfig b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ long e;

        public b(MultiLinkConfigManager r1, MultiLinkConfig r2, boolean r3, boolean r4, long r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void accept(Object r12) {
            ExtraResponse r13 = (ExtraResponse) r12;
            com.bytedance.android.live.revlink.impl.global.c r14 = this.a.e;
            MultiLinkAnchorControlContext r0 = null;
            if (r14 == null) goto L5;
            v r15 = r14.getMultiLinkMonitor();
        L6:
            if (r15 == null) goto L30;
            MultiLinkConfig r1 = this.b;
            boolean r2 = this.c;
            boolean r3 = this.d;
            i97.a r4 = i97.a.a;
            long r5 = System.currentTimeMillis() - this.e;
            Intrinsics.checkNotNullParameter(r1, "config");
            LinkedHashMap r7 = new LinkedHashMap();
            com.bytedance.android.live.revlink.impl.global.c r8 = r15.d;
            if (r8 == null) goto L10;
            MultiLinkAnchorControlContext r9 = r8.ua();
        L11:
            boolean r10 = false;
            if (r9 == null) goto L18;
            m<Boolean> r16 = r9.getForbidApply();
            if (r16 == null) goto L18;
            Boolean r17 = (Boolean) r16.getValue();
            if (r17 == null) goto L18;
            boolean r18 = r17.booleanValue();
        L19:
            r7.put("current_forbid_apply", Boolean.valueOf(r18));
            com.bytedance.android.live.revlink.impl.global.c r19 = r15.d;
            if (r19 == null) goto L22;
            r0 = r19.ua();
        L22:
            if (r0 == null) goto L28;
            m<Boolean> r6 = r0.getForbidInvite();
            if (r6 == null) goto L28;
            Boolean r20 = (Boolean) r6.getValue();
            if (r20 == null) goto L28;
            r10 = r20.booleanValue();
        L28:
            r7.put("current_forbid_invite", Boolean.valueOf(r10));
            r7.put("config", Integer.valueOf(r1.ordinal()));
            r7.put("expect_forbid_apply", Boolean.valueOf(r2));
            r7.put("expect_forbid_invite", Boolean.valueOf(r3));
            r7.put(Constants.Keys.duration, Long.valueOf(r5));
            r15.H("anchor_update_link_config_success", r7);
            return;
        L18:
            r18 = false;
            goto L19
        L10:
            r9 = null;
            goto L11
        L30:
            return;
        L5:
            r15 = null;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ MultiLinkConfigManager a;
        public final /* synthetic */ MultiLinkConfig b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ long e;

        public c(MultiLinkConfigManager r1, MultiLinkConfig r2, boolean r3, boolean r4, long r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void accept(Object r12) {
            Throwable r13 = (Throwable) r12;
            KmpWidget r0 = this.a.c;
            if (r0 == null) goto L5;
            Intrinsics.checkNotNullParameter(r0, "kmpWidget");
            Intrinsics.checkNotNullParameter(r0, "$this$androidContext");
            k.a(r0.getContext(), r13);
        L5:
            com.bytedance.android.live.revlink.impl.global.c r1 = this.a.e;
            MultiLinkAnchorControlContext r2 = null;
            if (r1 == null) goto L8;
            v r3 = r1.getMultiLinkMonitor();
        L9:
            if (r3 == null) goto L33;
            MultiLinkConfig r4 = this.b;
            boolean r5 = this.c;
            boolean r6 = this.d;
            i97.a r7 = i97.a.a;
            long r8 = System.currentTimeMillis() - this.e;
            Intrinsics.checkNotNullParameter(r4, "config");
            Intrinsics.checkNotNullParameter(r13, "it");
            LinkedHashMap r14 = new LinkedHashMap();
            com.bytedance.android.live.revlink.impl.global.c r9 = r3.d;
            if (r9 == null) goto L13;
            MultiLinkAnchorControlContext r10 = r9.ua();
        L14:
            boolean r15 = false;
            if (r10 == null) goto L21;
            m<Boolean> r16 = r10.getForbidApply();
            if (r16 == null) goto L21;
            Boolean r17 = (Boolean) r16.getValue();
            if (r17 == null) goto L21;
            boolean r18 = r17.booleanValue();
        L22:
            r14.put("current_forbid_apply", Boolean.valueOf(r18));
            com.bytedance.android.live.revlink.impl.global.c r19 = r3.d;
            if (r19 == null) goto L25;
            r2 = r19.ua();
        L25:
            if (r2 == null) goto L31;
            m<Boolean> r20 = r2.getForbidInvite();
            if (r20 == null) goto L31;
            Boolean r22 = (Boolean) r20.getValue();
            if (r22 == null) goto L31;
            r15 = r22.booleanValue();
        L31:
            r14.put("current_forbid_invite", Boolean.valueOf(r15));
            r14.put("config", Integer.valueOf(r4.ordinal()));
            r14.put("expect_forbid_apply", Boolean.valueOf(r5));
            r14.put("expect_forbid_invite", Boolean.valueOf(r6));
            r14.put(Constants.Keys.duration, Long.valueOf(r8));
            r3.H("anchor_update_link_config_failed", r14);
            return;
        L21:
            r18 = false;
            goto L22
        L13:
            r10 = null;
            goto L14
        L33:
            return;
        L8:
            r3 = null;
            goto L9
        }
    }

    public MultiLinkConfigManager(com.bytedance.android.livesdk.revenue.service.room.c r1, com.bytedance.android.live.revlink.impl.global.c r2) {
        this.d = r1;
        this.e = r2;
        this.a = new CompositeDisposable();
    }

    public final void a(f r3, KmpWidget r4) {
        Intrinsics.checkNotNullParameter(r4, "kmpWidget");
        this.b = r3;
        this.c = r4;
        if (r3 == null) goto L10;
        Observable r5 = h.a.a(r3, CommonMessageTypeKt.a(com.bytedance.android.live.revenue.common.message.a.g), false, 6);
        if (r5 == null) goto L11;
        final MultiLinkConfigManager$attach$1 r6 = new MultiLinkConfigManager$attach$1(this);
        Disposable r7 = r5.subscribe(new a(r6));
        if (r7 == null) goto L12;
        com.bytedance.revenue.platform.api.core.rx.f.a(r7, this.a);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void b(MultiLinkConfig r19, boolean r20, boolean r22) {
        i97.a r0 = i97.a.a;
        long r8 = System.currentTimeMillis();
        com.bytedance.android.live.revlink.impl.global.c r1 = this.e;
        LinkCrossRoomDataHolder r2 = null;
        if (r1 == null) goto L5;
        r31.a r10 = r1.getLinkNetwork();
    L6:
        if (r10 == null) goto L32;
        com.bytedance.android.live.revlink.impl.global.c r3 = this.e;
        if (r3 == null) goto L11;
        r2 = r3.getLinkCrossRoomDataHolder();
    L11:
        if (r2 == null) goto L13;
        long r12 = r2.c();
    L14:
        com.bytedance.android.livesdk.revenue.service.room.c r4 = this.d;
        if (r4 == null) goto L21;
        com.bytedance.android.livesdk.revenue.room.a r5 = r4.getRoomContext();
        if (r5 == null) goto L21;
        IRoomBase r6 = r5.getCommonRoom();
        if (r6 == null) goto L21;
        long r13 = IRoomKtKt.getId(r6);
    L22:
        Intrinsics.checkNotNullParameter(r19, "$this$toEffectiveField");
        Observable<ExtraResponse<Object, Extra>> r7 = r10.updateLinkMicConfig(r12, r13, String.valueOf(r19.ordinal()), r22, r20);
        if (r7 == null) goto L33;
        int r9 = p.a;
        Observable r14 = r7.subscribeOn(Schedulers.io());
        if (r14 == null) goto L34;
        Observable r15 = r14.observeOn(AndroidSchedulers.mainThread());
        if (r15 == null) goto L35;
        Disposable r16 = r15.subscribe(new b(this, r19, r20, r22, r8), new c(this, r19, r20, r22, r8));
        if (r16 == null) goto L36;
        com.bytedance.revenue.platform.api.core.rx.f.a(r16, this.a);
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L21:
        r13 = 0;
        goto L22
    L13:
        r12 = 0;
        goto L14
    L32:
        return;
    L5:
        r10 = null;
        goto L6
    }
}
