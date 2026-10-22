package io.noties.markwon.ext.tasklist;

import org.commonmark.node.CustomBlock;

/* JADX INFO: loaded from: classes6.dex */
public class b extends CustomBlock {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f16533a;

    public b(boolean r1) {
        this.f16533a = r1;
    }

    public boolean a() {
        return this.f16533a;
    }

    @Override // org.commonmark.node.Node
    public String toString() {
        return "TaskListItem{isDone=" + this.f16533a + '}';
    }
}
