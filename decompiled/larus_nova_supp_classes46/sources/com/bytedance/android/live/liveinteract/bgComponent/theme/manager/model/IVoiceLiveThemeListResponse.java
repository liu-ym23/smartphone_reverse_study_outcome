package com.bytedance.android.live.liveinteract.bgComponent.theme.manager.model;

import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R6\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0012\u001a\u00020\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\n\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\n\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R6\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\n\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR6\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b \u0010\n\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\b¨\u0006\""}, d2 = {"Lcom/bytedance/android/live/liveinteract/bgComponent/theme/manager/model/IVoiceLiveThemeListResponse;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getThemeList", "()Ljava/util/List;", "setThemeList", "(Ljava/util/List;)V", "getThemeList$annotations", "()V", "themeList", "", "getUgcAvailable", "()I", "setUgcAvailable", "(I)V", "getUgcAvailable$annotations", "ugcAvailable", "", "getLastThemeKey", "()Ljava/lang/String;", "setLastThemeKey", "(Ljava/lang/String;)V", "getLastThemeKey$annotations", "lastThemeKey", "getAnimatedType", "setAnimatedType", "getAnimatedType$annotations", "animatedType", "getImageType", "setImageType", "getImageType$annotations", "imageType", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IVoiceLiveThemeListResponse extends c<IVoiceLiveThemeListResponse> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ e castTo(Class r1);

    /* synthetic */ e castToOrNull(Class r1);

    @FieldName(name = "animated_exts")
    List<String> getAnimatedType();

    @FieldName(name = "image_exts")
    List<String> getImageType();

    @FieldName(name = "pre_choice")
    String getLastThemeKey();

    @FieldName(name = "bg_list")
    List<IVoiceLiveTheme> getThemeList();

    @FieldName(name = "ugc_available")
    int getUgcAvailable();

    @FieldName(name = "animated_exts#setter")
    void setAnimatedType(List<String> r1);

    @FieldName(name = "image_exts#setter")
    void setImageType(List<String> r1);

    @FieldName(name = "pre_choice#setter")
    void setLastThemeKey(String r1);

    @FieldName(name = "bg_list#setter")
    void setThemeList(List<? extends IVoiceLiveTheme> r1);

    @FieldName(name = "ugc_available#setter")
    void setUgcAvailable(int r1);
}
