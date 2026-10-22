package com.ss.android.lark.officesdk.launcher;

import android.content.Context;
import com.larksuite.framework.launch.task.AsyncLaunchTask;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.LarkContext;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/officesdk/launcher/InitOfficeSDKFileFgTask;", "Lcom/larksuite/framework/launch/task/AsyncLaunchTask;", "", "<init>", "()V", "execute", "", "context", "Landroid/content/Context;", "delayDuration", "", "Companion", "officesdk-assemble_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class InitOfficeSDKFileFgTask extends AsyncLaunchTask<Object> {

    public static final class a {
    }

    static {
    }

    public final int c() {
        return 2;
    }

    public InitOfficeSDKFileFgTask() {
    }

    public final void a(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        String r0 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d();
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        return;
    L8:
        com.ss.android.lark.featuregating.b.b r2 = new com.ss.android.lark.featuregating.b.b(r0, (jdb.e) e0c.k.a(com.larksuite.framework.utils.b.a, jdb.e.class));
        com.ss.android.lark.featuregating.b r7 = com.ss.android.lark.featuregating.b.d.b(r6);
        Intrinsics.checkNotNullParameter("init.language_task.sync", "fgKey");
        Intrinsics.checkNotNullParameter(r2, "fgSource");
        r7.b.put("init.language_task.sync", r2);
        Iterator r3 = r7.b.entrySet().iterator();
    L10:
        if (r3.hasNext() == false) goto L12;
        Map.Entry r4 = (Map.Entry) r3.next();
        String r5 = (String) r4.getKey();
        boolean r8 = ((com.ss.android.lark.featuregating.b.c) r4.getValue()).isEnable(r5);
        com.ss.android.lark.storage.kv.flash.c r9 = r7.a;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r5, "key");
        r9.a.putBoolean(r5, r8);
        Log.i("FlashFG", "update flash fg: key=" + r5 + ", value=" + r8);
        goto L10
    L12:
        return;
    L5:
        r1 = false;
        goto L6
    }
}
