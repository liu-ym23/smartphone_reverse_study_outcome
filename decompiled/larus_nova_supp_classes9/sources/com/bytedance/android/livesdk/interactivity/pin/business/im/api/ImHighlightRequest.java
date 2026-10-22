package com.bytedance.android.livesdk.interactivity.pin.business.im.api;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.api.room.ImCommonHighlightRequest")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/business/im/api/ImHighlightRequest;", BuildConfig.FLAVOR, "Ljava/util/HashMap;", BuildConfig.FLAVOR, "Lkotlin/collections/HashMap;", "toRequestFieldMap", "scene", "Ljava/lang/String;", BuildConfig.FLAVOR, "actionType", "I", BuildConfig.FLAVOR, "roomId", "J", "msgId", "commenterId", "pinId", "<init>", "()V", "Companion", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImHighlightRequest implements h {
    public static final int ACTION_TYPE_EDIT = 3;
    public static final int ACTION_TYPE_NOT_SUPPORT = 0;
    public static final int ACTION_TYPE_SET = 1;
    public static final int ACTION_TYPE_UNSET = 2;
    public static final a Companion = null;
    public static final String SCENE = "im_common_highlight";

    @SerializedName("action_type")
    public int actionType;

    @SerializedName("commenter_id")
    public long commenterId;

    @SerializedName("msg_id")
    public long msgId;

    @SerializedName("pin_id")
    public long pinId;

    @SerializedName("room_id")
    public long roomId;

    @SerializedName("scene")
    public String scene;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ImHighlightRequest() {
    }

    public final HashMap<String, String> toRequestFieldMap() {
        HashMap<String, String> r0 = new HashMap();
        String r1 = this.scene;
        if (r1 == null) goto L5;
        String r2 = r0.put("scene", r1);
    L5:
        r0.put("action_type", String.valueOf(this.actionType));
        r0.put("room_id", String.valueOf(this.roomId));
        r0.put("msg_id", String.valueOf(this.msgId));
        r0.put("commenter_id", String.valueOf(this.commenterId));
        r0.put("pin_id", String.valueOf(this.pinId));
        return r0;
    }

    public ImHighlightRequest(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L13;
        switch(r2) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.pinId = r5.j();
        goto L3
    L8:
        this.commenterId = r5.j();
        goto L3
    L9:
        this.msgId = r5.j();
        goto L3
    L10:
        this.roomId = r5.j();
        goto L3
    L11:
        this.actionType = r5.i();
        goto L3
    L12:
        this.scene = am3.h.c(r5);
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L13:
        r5.d(r0);
    }
}
