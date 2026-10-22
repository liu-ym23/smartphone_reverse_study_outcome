package com.larksuite.component.ui.tag.dto;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larksuite/component/ui/tag/dto/LarkTagType;", "", "Companion", "avatar-badge_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface LarkTagType {
    public static final a Companion = null;
    public static final int RELATION_TAG_EXTERNAL = 1;
    public static final int RELATION_TAG_PARTNER = 2;
    public static final int RELATION_TAG_TENANT_NAME = 3;
    public static final int TENANT_ENTITY_TAG = 4;
    public static final int UNKNOWN_TAG = 0;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.a;
    }
}
