package com.bytedance.android.live.base.model.message.guestlink;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.data.LinkmicGuestLinkUser")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0014\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b,\u0010-R/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R/\u0010\u0019\u001a\u0004\u0018\u00010\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001e\u001a\u00020\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010!\u001a\u00020\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0006\u001a\u0004\b \u0010\u001dR\u001b\u0010$\u001a\u00020\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0006\u001a\u0004\b#\u0010\u001dR+\u0010&\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\u0006\u001a\u0004\b&\u0010\u000f\"\u0004\b'\u0010\u0011R/\u0010+\u001a\u0004\u0018\u00010\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010\u0006\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018¨\u0006."}, d2 = {"Lcom/bytedance/android/live/base/model/message/guestlink/ILinkmicGuestLinkUserFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/message/guestlink/k;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "<set-?>", "user$delegate", "Ljava/lang/Object;", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "user", "", "score$delegate", "getScore", "()J", "setScore", "(J)V", "score", "", "scoreStr$delegate", "getScoreStr", "()Ljava/lang/String;", "setScoreStr", "(Ljava/lang/String;)V", "scoreStr", "", "userRole$delegate", "getUserRole", "()I", "userRole", "userRoleBefore$delegate", "getUserRoleBefore", "userRoleBefore", "linkType$delegate", "getLinkType", "linkType", "isBackground$delegate", "isBackground", "setBackground", "linkmicIdStr$delegate", "getLinkmicIdStr", "setLinkmicIdStr", "linkmicIdStr", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkmicGuestLinkUserFlexImpl extends FlexModelBase<k> implements k, vh7.h {

    @SerializedName("is_background")
    protected long _$$isBackground;

    @SerializedName("link_type")
    protected int _$$linkType;

    @SerializedName("linkmic_id_str")
    protected String _$$linkmicIdStr;

    @SerializedName("score")
    protected long _$$score;

    @SerializedName("score_str")
    protected String _$$scoreStr;

    @SerializedName("user")
    protected IBaseUser _$$user;

    @SerializedName("user_role")
    protected int _$$userRole;

    @SerializedName("audience_linkmic_role")
    protected int _$$userRoleBefore;

    public ILinkmicGuestLinkUserFlexImpl() {
        super(k.class);
        this._$$userRole = $defaultValue_userRole$();
        this._$$userRoleBefore = $defaultValue_userRoleBefore$();
        this._$$linkType = $defaultValue_linkType$();
    }

    public final int $defaultValue_linkType$() {
        return 0;
    }

    public final int $defaultValue_userRole$() {
        return LinkmicGuestLinkUserRole.LinkmicGuestLinkUserRole_Unknown.getValue();
    }

    public final int $defaultValue_userRoleBefore$() {
        return LinkmicGuestLinkUserRoleBefore.LinkmicGuestLinkUserRoleBefore_Audience.getValue();
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.k
    public final int getLinkType() {
        return this._$$linkType;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.k
    public final String getLinkmicIdStr() {
        return this._$$linkmicIdStr;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.k
    public final long getScore() {
        return this._$$score;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.k
    public final String getScoreStr() {
        return this._$$scoreStr;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.k
    public final IBaseUser getUser() {
        return this._$$user;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.k
    public final int getUserRole() {
        return this._$$userRole;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.k
    public final int getUserRoleBefore() {
        return this._$$userRoleBefore;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.k
    public final long isBackground() {
        return this._$$isBackground;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    public ILinkmicGuestLinkUserFlexImpl(am3.g r6) {
        super(k.class);
        int r0 = 0;
        setThreadSafe(false);
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L16;
        am3.g.a r4 = decodeExtensionFields(r3, r6);
        switch(r3) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L7;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            default: goto L7;
        };
    L8:
        this._$$isBackground = r6.j();
        r0 = r0 | 16;
        goto L3
    L9:
        this._$$linkmicIdStr = am3.h.c(r6);
        goto L3
    L10:
        this._$$linkType = r6.i();
        r0 = r0 | 8;
        goto L3
    L11:
        this._$$scoreStr = am3.h.c(r6);
        goto L3
    L12:
        this._$$userRoleBefore = r6.i();
        r0 = r0 | 4;
        goto L3
    L13:
        this._$$userRole = r6.i();
        r0 = r0 | 2;
        goto L3
    L14:
        this._$$score = r6.j();
        r0 = r0 | 1;
        goto L3
    L15:
        this._$$user = vh7.f.a(r6, IBaseUser.class);
        goto L3
    L7:
        am3.h.d(r4, r6);
        goto L3
    L16:
        r6.d(r1);
        setThreadSafe(true);
        if ((r0 & 2) != 0) goto L20;
        this._$$userRole = $defaultValue_userRole$();
    L20:
        if ((r0 & 4) != 0) goto L23;
        this._$$userRoleBefore = $defaultValue_userRoleBefore$();
    L23:
        if ((r0 & 8) != 0) goto L46;
        this._$$linkType = $defaultValue_linkType$();
        return;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.k
    public final void setBackground(long r1) {
        this._$$isBackground = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.k
    public final void setLinkmicIdStr(String r1) {
        this._$$linkmicIdStr = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.k
    public final void setScore(long r1) {
        this._$$score = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.k
    public final void setScoreStr(String r1) {
        this._$$scoreStr = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.k
    public final void setUser(IBaseUser r1) {
        this._$$user = r1;
    }
}
