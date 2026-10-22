package com.bytedance.android.ec.common.api;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.event.a;
import java.util.Map;
import kotlin.Metadata;
import mf.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J$\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH&J,\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H&J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\nH&J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\nH&¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/ec/common/api/IEShoppingCommonService;", "", "", a.KEY_LUBAN_TAG, "Ljava/lang/Class;", "Lmf/b;", "getOrderSchemaService", "Landroid/content/Context;", "context", "", "", "resources", "", "asyncInflate", "layoutId", "Landroid/view/ViewGroup;", "parent", "", "attachToParent", "Landroid/view/View;", "asyncInflateViewResult", "asyncInflateViewRes", "retainCount", "releaseSliceTemplateCache", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public interface IEShoppingCommonService {
    void asyncInflate(Context r1, Map<Integer, Integer> r10);

    boolean asyncInflateViewRes(Context r1, int r10);

    View asyncInflateViewResult(Context r1, int r10, ViewGroup r11, boolean r12);

    Class<? extends b> getOrderSchemaService(long r1);

    void releaseSliceTemplateCache(int r1);
}
