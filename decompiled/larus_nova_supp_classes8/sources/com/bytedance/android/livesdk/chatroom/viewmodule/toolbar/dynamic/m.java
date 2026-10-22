package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface m {
    s findContainButtonById(int r1);

    List<Integer> getAllShowedDataListIds();

    n getCheckManager();

    int getComponentByGroupId(int r1);

    int getComponentIndex(int r1);

    List<ToolbarButton> getFoldButtons(Boolean r1);

    boolean isComponentShowing(int r1);

    void refreshExistComponent(int r1);
}
