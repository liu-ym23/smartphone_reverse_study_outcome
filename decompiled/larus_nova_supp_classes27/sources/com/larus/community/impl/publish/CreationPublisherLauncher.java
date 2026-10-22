package com.larus.community.impl.publish;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.creation.PublisherCreation;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class CreationPublisherLauncher {
    public CreationPublisherLauncher() {
    }

    public static void a(PublisherCreation r9) {
        Intrinsics.checkNotNullParameter(r9, "publisherCreation");
        if (r9.isInfoNotEnough() == false) goto L12;
        FragmentActivity r0 = AppHost.a.a().getCurrentActivity();
        if ((r0 instanceof FragmentActivity) == false) goto L7;
        FragmentActivity r1 = r0;
    L8:
        if (r1 == null) goto L10;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r1), null, null, new CreationPublisherLauncher$preCreateIfAbsent$1$1(r9, null), 3, null);
        return;
    L10:
        FLogger.a.e("CreationPublisherLauncher", "preCreateIfAbsent: activity is null");
        return;
    L7:
        r1 = null;
        goto L8
    }
}
