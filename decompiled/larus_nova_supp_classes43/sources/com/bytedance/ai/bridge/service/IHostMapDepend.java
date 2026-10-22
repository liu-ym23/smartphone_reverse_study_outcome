package com.bytedance.ai.bridge.service;

import android.content.Context;
import com.bytedance.ai.bridge.method.system.AbsOpenMapAppMethodIDL;
import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001JO\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00030\fH&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/bridge/service/IHostMapDepend;", "", "openMapApp", "", "context", "Landroid/content/Context;", "mode", "Lcom/bytedance/ai/bridge/service/NavigateMode;", "dest", "Lcom/bytedance/ai/bridge/service/Location;", "origin", "callback", "Lkotlin/Function1;", "Lcom/bytedance/ai/bridge/method/system/AbsOpenMapAppMethodIDL$OpenMapAppResultModel;", "Lkotlin/ParameterName;", a.KEY_SHOPPING_GUIDE_NAME, "userAction", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IHostMapDepend {
    void openMapApp(Context r1, NavigateMode r10, Location r11, Location r12, Function1<? super AbsOpenMapAppMethodIDL.b, Unit> r13);
}
