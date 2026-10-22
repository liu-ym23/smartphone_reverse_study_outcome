package io.noties.markwon.ext.tasklist;

import org.commonmark.node.CustomBlock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class TaskListItem extends CustomBlock {
    public final boolean h;

    @Override // uvc.b
    public final String toString() {
        return "TaskListItem{isDone=" + this.h + '}';
    }

    public TaskListItem(boolean r1) {
        this.h = r1;
    }
}
