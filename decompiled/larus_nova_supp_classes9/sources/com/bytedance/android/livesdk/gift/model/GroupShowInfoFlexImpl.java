package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.data.GroupShowInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b4\u00105R7\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR+\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\r8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R/\u0010\u001a\u001a\u0004\u0018\u00010\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u00148V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R/\u0010\u001e\u001a\u0004\u0018\u00010\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u00148V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R/\u0010%\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u001f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010\u0007\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R+\u0010)\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\r8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010\u0007\u001a\u0004\b'\u0010\u0010\"\u0004\b(\u0010\u0012R+\u0010,\u001a\u00020*2\u0006\u0010\u0005\u001a\u00020*8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0007\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R+\u00103\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00148V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b0\u0010\u0007\u001a\u0004\b1\u0010\u0017\"\u0004\b2\u0010\u0019¨\u00066"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/GroupShowInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/w0;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/y0;", "<set-?>", "groupShowUsers$delegate", "Ljava/lang/Object;", "getGroupShowUsers", "()Ljava/util/List;", "setGroupShowUsers", "(Ljava/util/List;)V", "groupShowUsers", BuildConfig.FLAVOR, "descriptionStyle$delegate", "getDescriptionStyle", "()J", "setDescriptionStyle", "(J)V", "descriptionStyle", BuildConfig.FLAVOR, "title$delegate", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "title", "subTitle$delegate", "getSubTitle", "setSubTitle", "subTitle", "Lpy/k;", "backgroundImage$delegate", "getBackgroundImage", "()Lpy/k;", "setBackgroundImage", "(Lpy/k;)V", "backgroundImage", "groupShowScene$delegate", "getGroupShowScene", "setGroupShowScene", "groupShowScene", BuildConfig.FLAVOR, "isLiveShow$delegate", "isLiveShow", "()Z", "setLiveShow", "(Z)V", "toastText$delegate", "getToastText", "setToastText", "toastText", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GroupShowInfoFlexImpl extends FlexModelBase<w0> implements w0, vh7.h {

    @SerializedName("background_image")
    protected py.k _$$backgroundImage;

    @SerializedName("description_style")
    protected long _$$descriptionStyle;

    @SerializedName("group_show_scene")
    protected long _$$groupShowScene;

    @SerializedName("group_show_users")
    protected List<? extends y0> _$$groupShowUsers;

    @SerializedName("is_live_show")
    protected boolean _$$isLiveShow;

    @SerializedName("sub_title")
    protected String _$$subTitle;

    @SerializedName("title")
    protected String _$$title;

    @SerializedName("toast_text")
    protected String _$$toastText;

    public GroupShowInfoFlexImpl() {
        super(w0.class);
        this._$$groupShowUsers = $defaultValue_groupShowUsers$();
        this._$$isLiveShow = false;
        this._$$toastText = BuildConfig.FLAVOR;
    }

    public final List<y0> $defaultValue_groupShowUsers$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.livesdk.gift.model.w0
    public final py.k getBackgroundImage() {
        return this._$$backgroundImage;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w0
    public final long getDescriptionStyle() {
        return this._$$descriptionStyle;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w0
    public final long getGroupShowScene() {
        return this._$$groupShowScene;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w0
    public final List<y0> getGroupShowUsers() {
        return this._$$groupShowUsers;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w0
    public final String getSubTitle() {
        return this._$$subTitle;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w0
    public final String getTitle() {
        return this._$$title;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w0
    public final String getToastText() {
        return this._$$toastText;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w0
    public final boolean isLiveShow() {
        return this._$$isLiveShow;
    }

    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Object, py.k] */
    public GroupShowInfoFlexImpl(am3.g r7) {
        super(w0.class);
        this._$$groupShowUsers = new ArrayList();
        setThreadSafe(false);
        long r1 = r7.c();
        int r3 = 0;
    L3:
        int r4 = r7.f();
        if (r4 == (-1)) goto L16;
        am3.g.a r5 = decodeExtensionFields(r4, r7);
        switch(r4) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        this._$$toastText = am3.h.c(r7);
        goto L3
    L9:
        this._$$isLiveShow = am3.h.a(r7);
        r3 = r3 | 4;
        goto L3
    L10:
        this._$$groupShowScene = r7.j();
        r3 = r3 | 2;
        goto L3
    L11:
        this._$$backgroundImage = vh7.f.a(r7, py.k.class);
        goto L3
    L12:
        this._$$subTitle = am3.h.c(r7);
        goto L3
    L13:
        this._$$title = am3.h.c(r7);
        goto L3
    L14:
        this._$$descriptionStyle = r7.j();
        r3 = r3 | 1;
        goto L3
    L15:
        this._$$groupShowUsers.add(vh7.f.a(r7, y0.class));
        goto L3
    L7:
        am3.h.d(r5, r7);
        goto L3
    L16:
        r7.d(r1);
        setThreadSafe(true);
        if (this._$$groupShowUsers.isEmpty() == false) goto L20;
        this._$$groupShowUsers = $defaultValue_groupShowUsers$();
    L20:
        if ((r3 & 4) != 0) goto L23;
        this._$$isLiveShow = false;
    L23:
        if (this._$$toastText != null) goto L46;
        this._$$toastText = BuildConfig.FLAVOR;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w0
    public final void setBackgroundImage(py.k r1) {
        this._$$backgroundImage = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w0
    public final void setDescriptionStyle(long r1) {
        this._$$descriptionStyle = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w0
    public final void setGroupShowScene(long r1) {
        this._$$groupShowScene = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w0
    public final void setGroupShowUsers(List<? extends y0> r1) {
        this._$$groupShowUsers = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w0
    public final void setLiveShow(boolean r1) {
        this._$$isLiveShow = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w0
    public final void setSubTitle(String r1) {
        this._$$subTitle = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w0
    public final void setTitle(String r1) {
        this._$$title = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w0
    public final void setToastText(String r1) {
        this._$$toastText = r1;
    }
}
