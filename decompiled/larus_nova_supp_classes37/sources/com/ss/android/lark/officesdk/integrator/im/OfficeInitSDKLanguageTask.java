package com.ss.android.lark.officesdk.integrator.im;

import android.content.Context;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import java.util.Locale;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officesdk/integrator/im/OfficeInitSDKLanguageTask;", "Lcom/larksuite/framework/launch/task/AbstractLaunchTask;", "<init>", "()V", "execute", "", "context", "Landroid/content/Context;", "isAsync", "", "Companion", "officesdk-integrator-im_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class OfficeInitSDKLanguageTask extends AbstractLaunchTask<OfficeInitSDKLanguageTask> {

    public static final class a {
    }

    static {
    }

    public final boolean g() {
        return true;
    }

    public OfficeInitSDKLanguageTask() {
    }

    public final void a(Context r3) {
        Locale r4 = ((apb.a) k.a(LarkContext.getApplication(), apb.a.class)).f();
        if (r4 == null) goto L5;
        String r5 = r4.getLanguage();
    L6:
        Log.i("InitSDKLanguageTask", "loadSystemMessageTemplates language " + r5);
        ((IIMApi) ApiUtils.getApi(IIMApi.class)).loadSystemMessageTemplates(r5, true);
        return;
    L5:
        r5 = null;
        goto L6
    }
}
