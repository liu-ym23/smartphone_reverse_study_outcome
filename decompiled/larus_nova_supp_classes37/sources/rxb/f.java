package rxb;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R \u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\u0005R \u0010\u0018\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/officewebview/webview_api/platform/PlatformViewStateModel;", "", "viewId", "", "<init>", "(Ljava/lang/String;)V", "getViewId", "()Ljava/lang/String;", "rect", "Lcom/ss/android/lark/officewebview/webview_api/platform/ViewRect;", "getRect", "()Lcom/ss/android/lark/officewebview/webview_api/platform/ViewRect;", "factoryReg", "", "getFactoryReg", "()Z", "setFactoryReg", "(Z)V", "pluginAdd", "getPluginAdd", "setPluginAdd", "tag", "getTag", "setTag", "extra", "getExtra", "()Ljava/lang/Object;", "setExtra", "(Ljava/lang/Object;)V", "webview_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class f {

    @SerializedName("extra")
    private Object extra;

    @SerializedName("factory_reg")
    private boolean factoryReg;

    @SerializedName("plugin_add")
    private boolean pluginAdd;

    @SerializedName("rect")
    private final g rect;

    @SerializedName("tag")
    private String tag;

    @SerializedName("view_id")
    private final String viewId;

    public final Object a() {
        return this.extra;
    }

    public final g b() {
        return this.rect;
    }

    public f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "viewId");
        this.viewId = r2;
        this.rect = new g();
    }

    public final void c(Object r1) {
        this.extra = r1;
    }

    public final void d(boolean r1) {
        this.factoryReg = r1;
    }

    public final void e(boolean r1) {
        this.pluginAdd = r1;
    }

    public final void f(String r1) {
        this.tag = r1;
    }
}
