package com.ss.android.lark.picker.config;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.UserGroupScene;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/config/UserGroupVisibility;", "", "<init>", "()V", "Visible", "Invisible", "Lcom/ss/android/lark/picker/config/UserGroupVisibility$Invisible;", "Lcom/ss/android/lark/picker/config/UserGroupVisibility$Visible;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public abstract class UserGroupVisibility {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/picker/config/UserGroupVisibility$Invisible;", "Lcom/ss/android/lark/picker/config/UserGroupVisibility;", "<init>", "()V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Invisible extends UserGroupVisibility {
        public static final Invisible INSTANCE = null;

        static {
            INSTANCE = new Invisible();
        }

        private Invisible() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/config/UserGroupVisibility$Visible;", "Lcom/ss/android/lark/picker/config/UserGroupVisibility;", "scene", "Lcom/ss/android/lark/search/dto/UserGroupScene;", "<init>", "(Lcom/ss/android/lark/search/dto/UserGroupScene;)V", "getScene", "()Lcom/ss/android/lark/search/dto/UserGroupScene;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Visible extends UserGroupVisibility {
        private final UserGroupScene scene;

        public final UserGroupScene getScene() {
            return this.scene;
        }

        public Visible(UserGroupScene r2) {
            Intrinsics.checkNotNullParameter(r2, "scene");
            super(null);
            this.scene = r2;
        }
    }

    private UserGroupVisibility() {
    }

    public /* synthetic */ UserGroupVisibility(DefaultConstructorMarker r1) {
        this();
    }
}
