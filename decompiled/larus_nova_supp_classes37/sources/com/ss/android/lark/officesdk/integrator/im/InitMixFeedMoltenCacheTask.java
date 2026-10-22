package com.ss.android.lark.officesdk.integrator.im;

import android.content.Context;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.ss.android.lark.integrator.im.impl.feed.FlowFeedDataPreloader;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officesdk/integrator/im/InitMixFeedMoltenCacheTask;", "Lcom/larksuite/framework/launch/task/AbstractLaunchTask;", "<init>", "()V", "isAsync", "", "execute", "", "context", "Landroid/content/Context;", "Companion", "officesdk-integrator-im_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class InitMixFeedMoltenCacheTask extends AbstractLaunchTask<InitMixFeedMoltenCacheTask> {

    public static final class a {
    }

    static {
    }

    public final boolean g() {
        return true;
    }

    public InitMixFeedMoltenCacheTask() {
    }

    public final void a(Context r1) {
        ((com.ss.android.lark.feed.molten.cache.b) new FlowFeedDataPreloader().a.getValue()).d();
    }
}
