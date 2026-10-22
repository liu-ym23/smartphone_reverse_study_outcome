package com.larksuite.framework.section;

import android.content.Context;
import androidx.lifecycle.ViewModelStore;
import com.ss.android.lark.todo.impl.features.detail.TodoDetailFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface d {
    Context getContext();

    TodoDetailFragment getFragment();

    TodoDetailFragment getLifecycleOwner();

    ViewModelStore getViewModelStore();
}
