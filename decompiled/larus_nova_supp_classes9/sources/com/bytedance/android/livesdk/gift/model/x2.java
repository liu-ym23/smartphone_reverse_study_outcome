package com.bytedance.android.livesdk.gift.model;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u000e\u0010\u0004R\"\u0010\u0016\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0017\u0010\u0014R\"\u0010\u001c\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001a\u0010\u0014R6\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001dj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u001e8&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0006\u001a\u0004\b\u001f\u0010 R\u001c\u0010'\u001a\u0004\u0018\u00010#8&X§\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0006\u001a\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/x2;", "Lvh7/c;", BuildConfig.FLAVOR, "getTitle", "()Ljava/lang/String;", "getTitle$annotations", "()V", "title", "getText", "getText$annotations", "text", "getButtonText", "getButtonText$annotations", "buttonText", "getSchemeUrl", "getSchemeUrl$annotations", "schemeUrl", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getTitleImg", "()Lpy/k;", "getTitleImg$annotations", "titleImg", "getBackgroundImg", "getBackgroundImg$annotations", "backgroundImg", "getIconImage", "getIconImage$annotations", "iconImage", BuildConfig.FLAVOR, "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getExtra", "()Ljava/util/Map;", "getExtra$annotations", "extra", "Lcom/bytedance/android/livesdk/gift/model/y2;", "getPageProgressBar", "()Lcom/bytedance/android/livesdk/gift/model/y2;", "getPageProgressBar$annotations", "pageProgressBar", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface x2 extends vh7.c<x2> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "background_img")
    py.k getBackgroundImg();

    @FieldName(name = "button_text")
    String getButtonText();

    @FieldName(name = "extra")
    Map<String, String> getExtra();

    @FieldName(name = "icon_img")
    py.k getIconImage();

    @FieldName(name = "bar")
    y2 getPageProgressBar();

    @FieldName(name = "scheme_url")
    String getSchemeUrl();

    @FieldName(name = "text")
    String getText();

    @FieldName(name = "title")
    String getTitle();

    @FieldName(name = "title_img")
    py.k getTitleImg();
}
