package com.ss.android.lark.profile.v2.entity;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u00012\u00020\u0002:\u0001\fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/profile/v2/entity/TextListField;", "Lcom/ss/android/lark/profile/v2/entity/BaseField;", "Ljava/io/Serializable;", "<init>", "()V", "data", "", "Lcom/ss/android/lark/profile/v2/entity/TextField;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "Companion", "profile-entity_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class TextListField extends BaseField {
    public static final a Companion = null;
    private static final long serialVersionUID = -90018355;
    private List<TextField> data;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public TextListField() {
        this.data = new ArrayList();
    }

    public final List<TextField> getData() {
        return this.data;
    }

    public final void setData(List<TextField> r1) {
        this.data = r1;
    }
}
