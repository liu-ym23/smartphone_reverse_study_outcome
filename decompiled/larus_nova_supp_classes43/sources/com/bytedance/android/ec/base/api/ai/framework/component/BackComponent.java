package com.bytedance.android.ec.base.api.ai.framework.component;

import android.view.View;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/framework/component/BackComponent;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "extra", "", "", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "onClickListener", "Lcom/bytedance/android/ec/base/api/ai/framework/component/BackComponent$OnClickListener;", "getOnClickListener", "()Lcom/bytedance/android/ec/base/api/ai/framework/component/BackComponent$OnClickListener;", "setOnClickListener", "(Lcom/bytedance/android/ec/base/api/ai/framework/component/BackComponent$OnClickListener;)V", "scene", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "getView", "()Landroid/view/View;", "OnClickListener", "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
public final class BackComponent {
    private Map<String, ? extends Object> extra;
    private OnClickListener onClickListener;
    private String scene;
    private final View view;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bç\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/framework/component/BackComponent$OnClickListener;", "", "onClick", "", "view", "Landroid/view/View;", "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
    public interface OnClickListener {
        void onClick(View r1);
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public final OnClickListener getOnClickListener() {
        return this.onClickListener;
    }

    public final String getScene() {
        return this.scene;
    }

    public final View getView() {
        return this.view;
    }

    public BackComponent(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        this.view = r10;
    }

    public final void setExtra(Map<String, ? extends Object> r1) {
        this.extra = r1;
    }

    public final void setOnClickListener(OnClickListener r1) {
        this.onClickListener = r1;
    }

    public final void setScene(String r1) {
        this.scene = r1;
    }
}
