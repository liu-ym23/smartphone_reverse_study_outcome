package com.bytedance.android.live.liveinteract.theme;

import am3.g;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.api.room.RoomBgAddResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rR/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/theme/UploadBackgroundResponseKtFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/theme/UploadBackgroundResponseKt;", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;", "<set-?>", "voiceLiveTheme$delegate", "Ljava/lang/Object;", "getVoiceLiveTheme", "()Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;", "setVoiceLiveTheme", "(Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;)V", "voiceLiveTheme", "<init>", "()V", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class UploadBackgroundResponseKtFlexImpl extends FlexModelBase<UploadBackgroundResponseKt> implements UploadBackgroundResponseKt, h {

    @SerializedName("bg")
    protected IVoiceLiveTheme _$$voiceLiveTheme;

    public UploadBackgroundResponseKtFlexImpl() {
        super(UploadBackgroundResponseKt.class);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme, java.lang.Object] */
    public UploadBackgroundResponseKtFlexImpl(g r6) {
        super(UploadBackgroundResponseKt.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L9;
        g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L7;
        this._$$voiceLiveTheme = f.a(r6, IVoiceLiveTheme.class);
        goto L3
    L7:
        am3.h.d(r3, r6);
        goto L3
    L9:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.liveinteract.theme.UploadBackgroundResponseKt
    public final IVoiceLiveTheme getVoiceLiveTheme() {
        return this._$$voiceLiveTheme;
    }

    @Override // com.bytedance.android.live.liveinteract.theme.UploadBackgroundResponseKt
    public final void setVoiceLiveTheme(IVoiceLiveTheme r1) {
        this._$$voiceLiveTheme = r1;
    }
}
