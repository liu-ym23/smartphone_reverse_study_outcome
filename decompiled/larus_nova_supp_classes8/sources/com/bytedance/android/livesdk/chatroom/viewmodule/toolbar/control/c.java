package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control;

import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface c<T> {
    void dynamicSort(List<b> r1);

    List<T> getDynamicData(Function1<? super T, Boolean> r1);

    com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.h getDynamicStatus(b r1);

    f getServerConfigStyleInfo(int r1);

    f getServerConfigStyleInfo(b r1);

    boolean needDynamicSort();

    boolean needDynamicStatus();
}
