package com.bytedance.android.livesdk.gift.model;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0012\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0014\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR$\u0010\u0018\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/i;", "Lvh7/c;", BuildConfig.FLAVOR, "getLocked", "()Z", "setLocked", "(Z)V", "getLocked$annotations", "()V", "locked", BuildConfig.FLAVOR, "getToast", "()Ljava/lang/String;", "setToast", "(Ljava/lang/String;)V", "getToast$annotations", "toast", "getSchema", "setSchema", "getSchema$annotations", "schema", "getCellText", "setCellText", "getCellText$annotations", "cellText", "getUseCustomButtonColor", "getUseCustomButtonColor$annotations", "useCustomButtonColor", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface i extends vh7.c<i> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "cell_text")
    String getCellText();

    @FieldName(name = "locked")
    boolean getLocked();

    @FieldName(name = "schema")
    String getSchema();

    @FieldName(name = "toast")
    String getToast();

    @FieldName(name = "custom_button_color")
    boolean getUseCustomButtonColor();

    @FieldName(name = "cell_text#setter")
    void setCellText(String r1);

    @FieldName(name = "locked#setter")
    void setLocked(boolean r1);

    @FieldName(name = "schema#setter")
    void setSchema(String r1);

    @FieldName(name = "toast#setter")
    void setToast(String r1);
}
