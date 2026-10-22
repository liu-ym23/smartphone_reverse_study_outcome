package com.bytedance.android.live.profit.dress.config;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.dress.RolePropConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b2\u00103R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\bR\u001b\u0010\u0015\u001a\u00020\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0019\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0017\u0010\u0018R'\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001b0\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001d\u0010\u001eR'\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020 0\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0006\u001a\u0004\b\"\u0010\u001eR\u001d\u0010(\u001a\u0004\u0018\u00010$8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0006\u001a\u0004\b&\u0010'R\u001d\u0010+\u001a\u0004\u0018\u00010$8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0006\u001a\u0004\b*\u0010'R/\u00101\u001a\u0004\u0018\u00010$2\b\u0010,\u001a\u0004\u0018\u00010$8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b-\u0010\u0006\u001a\u0004\b.\u0010'\"\u0004\b/\u00100¨\u00064"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/IRolePropConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/dress/config/u;", "", "", "playType$delegate", "Ljava/lang/Object;", "getPlayType", "()Ljava/util/List;", "playType", "", "topic$delegate", "getTopic", "topic", "effectScenes$delegate", "getEffectScenes", "effectScenes", "", "globalValid$delegate", "getGlobalValid", "()Z", "globalValid", "allowListId$delegate", "getAllowListId", "()J", "allowListId", "", "Lcom/bytedance/android/live/profit/dress/config/IPropConfigFlexImpl;", "playerProp$delegate", "getPlayerProp", "()Ljava/util/Map;", "playerProp", "Lcom/bytedance/android/live/profit/dress/config/IPlayerDecorationFlexImpl;", "teamPlayerProp$delegate", "getTeamPlayerProp", "teamPlayerProp", "", "mvpEmojiDecorationId$delegate", "getMvpEmojiDecorationId", "()Ljava/lang/String;", "mvpEmojiDecorationId", "bloodBarStyleWebp$delegate", "getBloodBarStyleWebp", "bloodBarStyleWebp", "<set-?>", "mvpEmojiDecorationImg$delegate", "getMvpEmojiDecorationImg", "setMvpEmojiDecorationImg", "(Ljava/lang/String;)V", "mvpEmojiDecorationImg", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IRolePropConfigFlexImpl extends FlexModelBase<u> implements u, vh7.h {

    @SerializedName("allow_list_id")
    protected long _$$allowListId;

    @SerializedName("blood_bar_style_webp")
    protected String _$$bloodBarStyleWebp;

    @SerializedName("effect_scenes")
    protected List<Integer> _$$effectScenes;

    @SerializedName("global_valid")
    protected boolean _$$globalValid;

    @SerializedName("mvp_emoji_decoration_id")
    protected String _$$mvpEmojiDecorationId;

    @SerializedName("mvp_emoji_decoration_img")
    protected String _$$mvpEmojiDecorationImg;

    @SerializedName("play_type")
    protected List<Integer> _$$playType;

    @SerializedName("player_prop")
    protected Map<Long, IPropConfigFlexImpl> _$$playerProp;

    @SerializedName("team_player_prop")
    protected Map<Long, IPlayerDecorationFlexImpl> _$$teamPlayerProp;

    @SerializedName("topic")
    protected List<Long> _$$topic;

    public IRolePropConfigFlexImpl() {
        super(u.class);
        this._$$playType = $defaultValue_playType$();
        this._$$topic = $defaultValue_topic$();
        this._$$effectScenes = $defaultValue_effectScenes$();
        this._$$globalValid = false;
        this._$$playerProp = $defaultValue_playerProp$();
        this._$$teamPlayerProp = $defaultValue_teamPlayerProp$();
    }

    public final List<Integer> $defaultValue_effectScenes$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    public final List<Integer> $defaultValue_playType$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    public final Map<Long, IPropConfigFlexImpl> $defaultValue_playerProp$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
    }

    public final Map<Long, IPlayerDecorationFlexImpl> $defaultValue_teamPlayerProp$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
    }

    public final List<Long> $defaultValue_topic$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.live.profit.dress.config.u
    public final long getAllowListId() {
        return this._$$allowListId;
    }

    @Override // com.bytedance.android.live.profit.dress.config.u
    public final String getBloodBarStyleWebp() {
        return this._$$bloodBarStyleWebp;
    }

    @Override // com.bytedance.android.live.profit.dress.config.u
    public final List<Integer> getEffectScenes() {
        return this._$$effectScenes;
    }

    @Override // com.bytedance.android.live.profit.dress.config.u
    public final boolean getGlobalValid() {
        return this._$$globalValid;
    }

    @Override // com.bytedance.android.live.profit.dress.config.u
    public final String getMvpEmojiDecorationId() {
        return this._$$mvpEmojiDecorationId;
    }

    @Override // com.bytedance.android.live.profit.dress.config.u
    public final String getMvpEmojiDecorationImg() {
        return this._$$mvpEmojiDecorationImg;
    }

    @Override // com.bytedance.android.live.profit.dress.config.u
    public final List<Integer> getPlayType() {
        return this._$$playType;
    }

    @Override // com.bytedance.android.live.profit.dress.config.u
    public final Map<Long, IPropConfigFlexImpl> getPlayerProp() {
        return this._$$playerProp;
    }

    @Override // com.bytedance.android.live.profit.dress.config.u
    public final Map<Long, IPlayerDecorationFlexImpl> getTeamPlayerProp() {
        return this._$$teamPlayerProp;
    }

    @Override // com.bytedance.android.live.profit.dress.config.u
    public final List<Long> getTopic() {
        return this._$$topic;
    }

    public IRolePropConfigFlexImpl(am3.g r19) {
        super(u.class);
        this._$$playType = new ArrayList();
        this._$$topic = new ArrayList();
        this._$$effectScenes = new ArrayList();
        this._$$playerProp = new HashMap();
        this._$$teamPlayerProp = new HashMap();
        setThreadSafe(false);
        long r3 = r19.c();
        int r5 = 0;
    L3:
        int r6 = r19.f();
        if (r6 == (-1)) goto L50;
        am3.g.a r9 = decodeExtensionFields(r6, r19);
        Long r13 = null;
        switch(r6) {
            case 1: goto L47;
            case 2: goto L46;
            case 3: goto L45;
            case 4: goto L44;
            case 5: goto L43;
            case 6: goto L27;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            default: goto L7;
        };
    L8:
        this._$$mvpEmojiDecorationImg = am3.h.c(r19);
        goto L3
    L9:
        this._$$bloodBarStyleWebp = am3.h.c(r19);
        goto L3
    L10:
        this._$$mvpEmojiDecorationId = am3.h.c(r19);
        goto L3
    L11:
        long r14 = r19.c();
        Object r7 = null;
    L12:
        int r10 = r19.f();
        if (r10 == (-1)) goto L19;
        if (r10 != 1) goto L15;
        r13 = Long.valueOf(r19.j());
        goto L12
    L15:
        if (r10 != 2) goto L16;
        r7 = new IPlayerDecorationFlexImpl(r19);
        goto L12
    L16:
        am3.h.e(r19);
        goto L12
    L19:
        r19.d(r14);
        Map r8 = this._$$teamPlayerProp;
        if (r13 == null) goto L26;
        if (r7 == null) goto L24;
    L38:
        r8.put(r13, r7);
        goto L3
    L24:
        throw new IllegalStateException("Value must not be null");
    L26:
        throw new IllegalStateException("Key must not be null");
    L27:
        long r15 = r19.c();
        r7 = null;
    L28:
        int r12 = r19.f();
        if (r12 == (-1)) goto L35;
        if (r12 != 1) goto L31;
        r13 = Long.valueOf(r19.j());
        goto L28
    L31:
        if (r12 != 2) goto L32;
        r7 = new IPropConfigFlexImpl(r19);
        goto L28
    L32:
        am3.h.e(r19);
        goto L28
    L35:
        r19.d(r15);
        r8 = this._$$playerProp;
        if (r13 == null) goto L42;
        if (r7 != null) goto L38;
        throw new IllegalStateException("Value must not be null");
    L42:
        throw new IllegalStateException("Key must not be null");
    L43:
        this._$$allowListId = r19.j();
        r5 = r5 | 2;
        goto L3
    L44:
        this._$$globalValid = am3.h.a(r19);
        r5 = r5 | 1;
        goto L3
    L45:
        List r16 = this._$$effectScenes;
    L48:
        Object r17 = Integer.valueOf(r19.i());
    L49:
        r16.add(r17);
        goto L3
    L46:
        r16 = this._$$topic;
        r17 = Long.valueOf(r19.j());
        goto L49
    L47:
        r16 = this._$$playType;
        goto L48
    L7:
        am3.h.d(r9, r19);
        goto L3
    L50:
        r19.d(r3);
        setThreadSafe(true);
        if (this._$$playType.isEmpty() == false) goto L54;
        this._$$playType = $defaultValue_playType$();
    L54:
        if (this._$$topic.isEmpty() == false) goto L57;
        this._$$topic = $defaultValue_topic$();
    L57:
        if (this._$$effectScenes.isEmpty() == false) goto L60;
        this._$$effectScenes = $defaultValue_effectScenes$();
    L60:
        if ((r5 & 1) != 0) goto L63;
        this._$$globalValid = false;
    L63:
        if (this._$$playerProp != null) goto L66;
        this._$$playerProp = $defaultValue_playerProp$();
    L66:
        if (this._$$teamPlayerProp != null) goto L112;
        this._$$teamPlayerProp = $defaultValue_teamPlayerProp$();
        return;
    }

    @Override // com.bytedance.android.live.profit.dress.config.u
    public final void setMvpEmojiDecorationImg(String r1) {
        this._$$mvpEmojiDecorationImg = r1;
    }
}
