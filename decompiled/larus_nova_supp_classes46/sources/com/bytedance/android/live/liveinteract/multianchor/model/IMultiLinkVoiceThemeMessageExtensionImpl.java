package com.bytedance.android.live.liveinteract.multianchor.model;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.livesdk.message.model.hc;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010'\u001a\u00020\u0002¢\u0006\u0004\b(\u0010)J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR(\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00128\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001e\u0010 \u001a\u0004\u0018\u00010\u001b8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010&\u001a\u0004\u0018\u00010!8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006*"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multianchor/model/IMultiLinkVoiceThemeMessageExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/message/model/hc;", "Lcom/bytedance/android/live/liveinteract/multianchor/model/f;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lcom/bytedance/android/live/base/model/message/m0;", "value", "getCommonData", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommonData", "(Lcom/bytedance/android/live/base/model/message/m0;)V", "commonData", "", "getBgType", "()Ljava/lang/Integer;", "setBgType", "(Ljava/lang/Integer;)V", "bgType", "getReviewPass", "setReviewPass", "reviewPass", "", "getToastText", "()Ljava/lang/String;", "setToastText", "(Ljava/lang/String;)V", "toastText", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;", "getVoiceLiveTheme", "()Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;", "setVoiceLiveTheme", "(Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;)V", "voiceLiveTheme", "base", "<init>", "(Lcom/bytedance/android/livesdk/message/model/hc;)V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IMultiLinkVoiceThemeMessageExtensionImpl extends ModelExtensionBase<hc, f> implements f, hc {
    private final /* synthetic */ hc $$delegate_0;

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.f
    public <R extends vh7.e<hc>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.f
    public <R extends vh7.e<hc>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.f
    public Integer getBgType() {
        return this.$$delegate_0.getBgType();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.f
    public m0 getCommonData() {
        return (m0) get(1, f.class);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.f
    public Integer getReviewPass() {
        return this.$$delegate_0.getReviewPass();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.f
    public String getToastText() {
        return this.$$delegate_0.getToastText();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.f
    public IVoiceLiveTheme getVoiceLiveTheme() {
        return this.$$delegate_0.getVoiceLiveTheme();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.f
    public void setBgType(Integer r2) {
        this.$$delegate_0.setBgType(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.f
    public void setReviewPass(Integer r2) {
        this.$$delegate_0.setReviewPass(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.f
    public void setToastText(String r2) {
        this.$$delegate_0.setToastText(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.f
    public void setVoiceLiveTheme(IVoiceLiveTheme r2) {
        this.$$delegate_0.setVoiceLiveTheme(r2);
    }

    public IMultiLinkVoiceThemeMessageExtensionImpl(hc r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.f
    public void setCommonData(m0 r4) {
        set(1, "common", f.class, r4);
    }
}
