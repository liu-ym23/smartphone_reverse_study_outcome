package com.bytedance.android.live.liveinteract.bgComponent.theme.manager.model;

import am3.g;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.api.room.GetAudioBGResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b#\u0010$R;\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR+\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\r8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R/\u0010\u001a\u001a\u0004\u0018\u00010\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u00148V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R;\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR;\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0007\u001a\u0004\b \u0010\t\"\u0004\b!\u0010\u000b¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/liveinteract/bgComponent/theme/manager/model/IVoiceLiveThemeListResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/bgComponent/theme/manager/model/IVoiceLiveThemeListResponse;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;", "<set-?>", "themeList$delegate", "Ljava/lang/Object;", "getThemeList", "()Ljava/util/List;", "setThemeList", "(Ljava/util/List;)V", "themeList", "", "ugcAvailable$delegate", "getUgcAvailable", "()I", "setUgcAvailable", "(I)V", "ugcAvailable", "", "lastThemeKey$delegate", "getLastThemeKey", "()Ljava/lang/String;", "setLastThemeKey", "(Ljava/lang/String;)V", "lastThemeKey", "animatedType$delegate", "getAnimatedType", "setAnimatedType", "animatedType", "imageType$delegate", "getImageType", "setImageType", "imageType", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IVoiceLiveThemeListResponseFlexImpl extends FlexModelBase<IVoiceLiveThemeListResponse> implements IVoiceLiveThemeListResponse, h {

    @SerializedName("animated_exts")
    protected List<String> _$$animatedType;

    @SerializedName("image_exts")
    protected List<String> _$$imageType;

    @SerializedName("pre_choice")
    protected String _$$lastThemeKey;

    @SerializedName("bg_list")
    protected List<? extends IVoiceLiveTheme> _$$themeList;

    @SerializedName("ugc_available")
    protected int _$$ugcAvailable;

    public IVoiceLiveThemeListResponseFlexImpl() {
        super(IVoiceLiveThemeListResponse.class);
    }

    @Override // com.bytedance.android.live.liveinteract.bgComponent.theme.manager.model.IVoiceLiveThemeListResponse
    public final List<String> getAnimatedType() {
        return this._$$animatedType;
    }

    @Override // com.bytedance.android.live.liveinteract.bgComponent.theme.manager.model.IVoiceLiveThemeListResponse
    public final List<String> getImageType() {
        return this._$$imageType;
    }

    @Override // com.bytedance.android.live.liveinteract.bgComponent.theme.manager.model.IVoiceLiveThemeListResponse
    public final String getLastThemeKey() {
        return this._$$lastThemeKey;
    }

    @Override // com.bytedance.android.live.liveinteract.bgComponent.theme.manager.model.IVoiceLiveThemeListResponse
    public final List<IVoiceLiveTheme> getThemeList() {
        return this._$$themeList;
    }

    @Override // com.bytedance.android.live.liveinteract.bgComponent.theme.manager.model.IVoiceLiveThemeListResponse
    public final int getUgcAvailable() {
        return this._$$ugcAvailable;
    }

    public IVoiceLiveThemeListResponseFlexImpl(g r6) {
        super(IVoiceLiveThemeListResponse.class);
        this._$$themeList = new ArrayList();
        this._$$animatedType = new ArrayList();
        this._$$imageType = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L23;
        g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 == 1) goto L21;
        if (r2 != 2) goto L10;
        this._$$ugcAvailable = r6.i();
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$lastThemeKey = am3.h.c(r6);
        goto L3
    L12:
        if (r2 == 4) goto L17;
        if (r2 != 5) goto L15;
        List<? extends IVoiceLiveTheme> r4 = this._$$imageType;
    L18:
        Object r5 = am3.h.c(r6);
    L22:
        r4.add(r5);
        goto L3
    L15:
        am3.h.d(r3, r6);
        goto L3
    L17:
        r4 = this._$$animatedType;
        goto L18
    L21:
        r4 = this._$$themeList;
        r5 = f.a(r6, IVoiceLiveTheme.class);
        goto L22
    L23:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.liveinteract.bgComponent.theme.manager.model.IVoiceLiveThemeListResponse
    public final void setAnimatedType(List<String> r1) {
        this._$$animatedType = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.bgComponent.theme.manager.model.IVoiceLiveThemeListResponse
    public final void setImageType(List<String> r1) {
        this._$$imageType = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.bgComponent.theme.manager.model.IVoiceLiveThemeListResponse
    public final void setLastThemeKey(String r1) {
        this._$$lastThemeKey = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.bgComponent.theme.manager.model.IVoiceLiveThemeListResponse
    public final void setThemeList(List<? extends IVoiceLiveTheme> r1) {
        this._$$themeList = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.bgComponent.theme.manager.model.IVoiceLiveThemeListResponse
    public final void setUgcAvailable(int r1) {
        this._$$ugcAvailable = r1;
    }
}
