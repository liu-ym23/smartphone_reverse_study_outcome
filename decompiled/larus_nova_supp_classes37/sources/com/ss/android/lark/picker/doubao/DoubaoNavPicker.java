package com.ss.android.lark.picker.doubao;

import android.content.Context;
import android.util.AttributeSet;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.picker.Dependency;
import com.ss.android.lark.picker.NavPicker;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.config.ConfigKt;
import com.ss.android.lark.picker.config.Permissions;
import com.ss.android.lark.picker.doubao.entity.DoubaoPickerConfig;
import com.ss.android.lark.picker.doubao.view.DoubaoItemViewBridgeFactory;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/picker/doubao/DoubaoNavPicker;", "Lcom/ss/android/lark/picker/NavPicker;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "init", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "initConfig", "Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerConfig;", "Companion", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class DoubaoNavPicker extends NavPicker {
    public static final Companion Companion = null;
    public static final String TAG = "DoubaoNavPicker";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/doubao/DoubaoNavPicker$Companion;", "", "<init>", "()V", "TAG", "", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public DoubaoNavPicker(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.picker.doubao.DoubaoNavPicker$init$onItemClickHandler$1] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.ss.android.lark.picker.doubao.DoubaoNavPicker$init$doubaoBinder$1] */
    public final void init(final FragmentActivity r5, final DoubaoPickerConfig r6) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r6, "initConfig");
        final ?? r0 = new DoubaoNavPicker$init$onItemClickHandler$1(r6, r5);
        final DoubaoItemViewBridgeFactory r1 = new DoubaoItemViewBridgeFactory();
        final ?? r2 = new DoubaoNavPicker$init$doubaoBinder$1(r5, r0, r1);
        init2(ConfigKt.navPickerConfig(new Dependency(r5, r5.getSupportFragmentManager()), new Permissions(CollectionsKt.emptyList()), new DoubaoNavPicker$init$config$1(r6, r2, r5)));
    }

    public /* synthetic */ DoubaoNavPicker(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }
}
