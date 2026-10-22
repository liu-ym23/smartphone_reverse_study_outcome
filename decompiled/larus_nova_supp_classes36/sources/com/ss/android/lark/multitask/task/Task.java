package com.ss.android.lark.multitask.task;

import android.os.Parcelable;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface Task extends LifecycleOwner {

    /* JADX INFO: renamed from: com.ss.android.lark.multitask.task.Task$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static String $default$getType(Task r0) {
            return "undefined";
        }

        public static String $default$getIdentifier(Task r0) {
            return r0.getTitle().toString();
        }
    }

    public interface IconFactory extends Parcelable {
    }

    String getIdentifier();

    CharSequence getTitle();

    String getType();
}
