package com.bytedance.lark.lark_biz_feed_android;

import kotlin.NoWhenBranchMatchedException;
import lark_biz_feed.proto.ChannelEntity;
import lark_biz_feed.proto.LarkBizFeedStructPayload227619f5325cb7cd;
import lark_biz_feed.proto.LarkBizFeedStructPayload2b2517acb416c4dd;
import lark_biz_feed.proto.LarkBizFeedStructPayload2eaf423772123ddd;
import lark_biz_feed.proto.LarkBizFeedStructPayload467788b2cd36fc07;
import lark_biz_feed.proto.LarkBizFeedStructPayload4c1debabb59c79d0;
import lark_biz_feed.proto.LarkBizFeedStructPayload6818d699db356952;
import lark_biz_feed.proto.LarkBizFeedStructPayload69115a2878680bc6;
import lark_biz_feed.proto.LarkBizFeedStructPayload6f39b401968ec98b;
import lark_biz_feed.proto.LarkBizFeedStructPayload7e251b9c83581426;
import lark_biz_feed.proto.LarkBizFeedStructPayloadB8cbcc55056b5a14;
import lark_biz_feed.proto.LarkBizFeedStructPayloadBbbf6bfd1b7d76e7;
import lark_biz_feed.proto.LarkBizFeedStructPayloadBfabc31623467351;
import lark_biz_feed.proto.LarkBizFeedStructPayloadCb51aa4e0dfa46c1;
import lark_biz_feed.proto.LarkFeedListAction;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class o {
    public o() {
    }

    public final LarkFeedListAction a() {
        if ((this instanceof d0) == false) goto L6;
        return new LarkFeedListAction.Builder().setup(Boolean.TRUE).build();
    L6:
        if ((this instanceof u) == false) goto L9;
        return new LarkFeedListAction.Builder().pause_data_change_notify(Boolean.TRUE).build();
    L9:
        if ((this instanceof z) == false) goto L12;
        return new LarkFeedListAction.Builder().resume_data_change_notify(Boolean.TRUE).build();
    L12:
        if ((this instanceof y) == false) goto L15;
        return new LarkFeedListAction.Builder().refresh(new LarkBizFeedStructPayload69115a2878680bc6(((y) this).a.into())).build();
    L15:
        if ((this instanceof p) == false) goto L18;
        return new LarkFeedListAction.Builder().clear_badge(new LarkBizFeedStructPayload6f39b401968ec98b(((p) this).a.a())).build();
    L18:
        if ((this instanceof t) == false) goto L21;
        t r2 = (t) this;
        return new LarkFeedListAction.Builder().mark_item_as_un_read(new LarkBizFeedStructPayloadBfabc31623467351(r2.a.a(), Boolean.valueOf(r2.b))).build();
    L21:
        if ((this instanceof c0) == false) goto L24;
        c0 r3 = (c0) this;
        return new LarkFeedListAction.Builder().set_topping(new LarkBizFeedStructPayloadB8cbcc55056b5a14(r3.a.a(), Boolean.valueOf(r3.b))).build();
    L24:
        if ((this instanceof b0) == false) goto L27;
        b0 r4 = (b0) this;
        return new LarkFeedListAction.Builder().set_no_disturb(new LarkBizFeedStructPayload4c1debabb59c79d0(r4.a.a(), Boolean.valueOf(r4.b))).build();
    L27:
        if ((this instanceof e0) == false) goto L30;
        return new LarkFeedListAction.Builder().switch_auto_mute(new LarkBizFeedStructPayload2eaf423772123ddd(Long.valueOf(((e0) this).a))).build();
    L30:
        if ((this instanceof r) == false) goto L33;
        return new LarkFeedListAction.Builder().delete_item(new LarkBizFeedStructPayload6818d699db356952(((r) this).a.a())).build();
    L33:
        if ((this instanceof s) == false) goto L40;
        LarkFeedListAction.Builder r0 = new LarkFeedListAction.Builder();
        f r5 = ((s) this).a;
        String r6 = r5.a;
        FeedCardType r7 = r5.b;
        if (r7 == null) goto L37;
        lark_biz_feed.proto.FeedCardType r8 = r7.into();
    L67:
        return r0.hide_item(new LarkBizFeedStructPayloadCb51aa4e0dfa46c1(new ChannelEntity(r6, r8))).build();
    L37:
        r8 = null;
        goto L67
    L40:
        if ((this instanceof a0) == false) goto L43;
        return new LarkFeedListAction.Builder().set_done(new LarkBizFeedStructPayload227619f5325cb7cd(((a0) this).a.a())).build();
    L43:
        if ((this instanceof v) == false) goto L46;
        return new LarkFeedListAction.Builder().preload_items_data(new LarkBizFeedStructPayload467788b2cd36fc07(((v) this).a)).build();
    L46:
        if ((this instanceof w) == false) goto L49;
        w r9 = (w) this;
        return new LarkFeedListAction.Builder().preload_items_dependency(new LarkBizFeedStructPayload7e251b9c83581426(r9.a, Integer.valueOf(r9.b))).build();
    L49:
        if ((this instanceof q) == false) goto L52;
        q r10 = (q) this;
        return new LarkFeedListAction.Builder().data_loading_check(new LarkBizFeedStructPayload2b2517acb416c4dd(r10.a.into(), Integer.valueOf(r10.b), Boolean.valueOf(r10.c))).build();
    L52:
        if ((this instanceof x) == false) goto L56;
        return new LarkFeedListAction.Builder().preload_next_unread(new LarkBizFeedStructPayloadBbbf6bfd1b7d76e7(((x) this).a)).build();
    L56:
        throw new NoWhenBranchMatchedException();
    }
}
