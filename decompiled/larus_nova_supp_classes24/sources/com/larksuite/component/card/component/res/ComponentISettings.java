package com.larksuite.component.card.component.res;

import com.google.gson.annotations.SerializedName;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@AppConfig(key = "msg_card_template_config")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R6\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR6\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/larksuite/component/card/component/res/ComponentISettings;", "", "<init>", "()V", "components", "Ljava/util/HashMap;", "", "Lcom/larksuite/component/card/component/res/ComponentISettings$Component;", "Lkotlin/collections/HashMap;", "getComponents", "()Ljava/util/HashMap;", "dynamicComponents", "getDynamicComponents", "Component", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ComponentISettings {

    @SerializedName("components")
    private final HashMap<String, a> components;

    @SerializedName("dynamic_components")
    private final HashMap<String, a> dynamicComponents;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/larksuite/component/card/component/res/ComponentISettings$Component;", "", "<init>", "()V", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "md5", "getMd5", "setMd5", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class a {

        @SerializedName("md5")
        private String md5;

        @SerializedName("url")
        private String url;

        public a() {
        }

        public final String a() {
            return this.md5;
        }

        public final String b() {
            return this.url;
        }
    }

    public ComponentISettings() {
    }

    public final HashMap<String, a> getComponents() {
        return this.components;
    }

    public final HashMap<String, a> getDynamicComponents() {
        return this.dynamicComponents;
    }
}
