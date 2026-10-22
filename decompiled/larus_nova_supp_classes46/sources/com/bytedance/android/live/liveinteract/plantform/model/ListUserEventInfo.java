package com.bytedance.android.live.liveinteract.plantform.model;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u001dB\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\tR\"\u0010\r\u001a\u00020\f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/ListUserEventInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/plantform/model/c0;", "Landroid/text/Spannable;", "eventInfo", "", "placeholder", "wrapperText", "exposeName", "", "isEcom", "needPlaceHolder", "", "eventInfoType", "I", "getEventInfoType", "()I", "setEventInfoType", "(I)V", "Lcom/bytedance/android/livesdkapi/message/Text;", "content", "Lcom/bytedance/android/livesdkapi/message/Text;", "getContent", "()Lcom/bytedance/android/livesdkapi/message/Text;", "setContent", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", "<init>", "()V", "Companion", "a", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ListUserEventInfo extends FlexModelBase<c0> implements c0, vh7.h {
    public static final a Companion = null;
    public static final int LIST_USER_EVENT_INFO_TYPE_ADD_PRICE = 4;
    public static final int LIST_USER_EVENT_INFO_TYPE_ECOM_PURCHASED = 6;
    public static final int LIST_USER_EVENT_INFO_TYPE_ECOM_VIEW = 5;
    public static final int LIST_USER_EVENT_INFO_TYPE_INVITE_FRIEND = 3;
    public static final int LIST_USER_EVENT_INFO_TYPE_KTV = 2;
    public static final int LIST_USER_EVENT_INFO_TYPE_NONE = 0;
    public static final int LIST_USER_EVENT_INFO_TYPE_SEARCH = 7;
    public static final int LIST_USER_EVENT_INFO_TYPE_TEAM_FIGHT = 1;

    @SerializedName("content")
    protected Text content;

    @SerializedName("event_info_type")
    protected int eventInfoType;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ListUserEventInfo() {
        super(c0.class);
    }

    public final String exposeName() {
        int r0 = getEventInfoType();
        if (r0 != 5) goto L5;
        return "browse";
    L5:
        if (r0 == 6) goto L7;
        return "";
    L7:
        return "order";
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.c0
    public /* bridge */ /* synthetic */ a5 getContent() {
        return m255getContent();
    }

    public final boolean isEcom() {
        if (getEventInfoType() != 5) goto L5;
    L8:
        return true;
    L5:
        if (getEventInfoType() == 6) goto L8;
        return false;
    }

    public final boolean needPlaceHolder() {
        if (getEventInfoType() != 2) goto L5;
    L7:
        return false;
    L5:
        if (getEventInfoType() == 4) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.c0
    public int getEventInfoType() {
        return this.eventInfoType;
    }

    /* JADX INFO: renamed from: getContent, reason: collision with other method in class */
    public Text m255getContent() {
        return this.content;
    }

    public ListUserEventInfo(am3.g r6) {
        super(c0.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.eventInfoType = r6.i();
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.content = _Text_ProtoDecoder.decodeStatic(r6);
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
    }

    public void setContent(Text r1) {
        this.content = r1;
    }

    public void setEventInfoType(int r1) {
        this.eventInfoType = r1;
    }

    public final Spannable wrapperText(Spannable r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "eventInfo");
        Intrinsics.checkNotNullParameter(r5, "placeholder");
        if (needPlaceHolder() == false) goto L22;
        boolean r1 = true;
        if (r5.length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L22;
        if (r4.length() == 0) goto L14;
        r1 = false;
    L14:
        if (r1 == true) goto L16;
        SpannableStringBuilder r2 = new SpannableStringBuilder();
        if (isEcom() == false) goto L20;
        r2.append(r4);
        r2.append(" | " + r5);
    L21:
        return r2;
    L20:
        r2.append(r5 + " | ");
        r2.append(r4);
        goto L21
    L16:
        return new SpannableString(r5);
    L7:
        r0 = false;
    L22:
        return r4;
    }
}
