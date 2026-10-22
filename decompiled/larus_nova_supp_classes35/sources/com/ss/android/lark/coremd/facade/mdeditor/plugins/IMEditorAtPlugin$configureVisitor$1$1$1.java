package com.ss.android.lark.coremd.facade.mdeditor.plugins;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.coremd.base.parse.r;
import com.ss.android.lark.coremd.base.parse.x;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/coremd/facade/mdeditor/plugins/IMEditorAtPlugin$configureVisitor$1$1$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/coremdbiz/facade/node/AtNode;", "onSuccess", BuildConfig.FLAVOR, "node", "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IMEditorAtPlugin$configureVisitor$1$1$1 implements IGetDataCallback<eab.a> {
    final /* synthetic */ x.a $it;
    final /* synthetic */ r<eab.a> $this_on;
    final /* synthetic */ a this$0;

    public void onError(ErrorResult r2) {
        Intrinsics.checkNotNullParameter(r2, "err");
        Log.i("IMEditorAtPlugin", "load at failed, build spannable from origin atNode ,user id is " + this.$this_on.getNode().k);
    }

    public void onSuccess(eab.a r3) {
        Log.d("IMEditorAtPlugin", "text future resolved");
        if (r3 != null) goto L5;
        return;
    L5:
        int r4 = a.a;
        throw null;
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((eab.a) r1);
    }

    public IMEditorAtPlugin$configureVisitor$1$1$1(x.a r1, a r2, r<eab.a> r3) {
        this.$it = r1;
        this.$this_on = r3;
    }
}
