package kotlin.reflect.jvm.internal.impl.utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public class DFS {

    public static abstract class AbstractNodeHandler<N, R> implements NodeHandler<N, R> {
        public AbstractNodeHandler() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
        public void afterChildren(N r10) {
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
        public boolean beforeChildren(N r10) {
            return true;
        }
    }

    public static abstract class CollectingNodeHandler<N, R, C extends Iterable<R>> extends AbstractNodeHandler<N, C> {
        protected final C result;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            if (r10 == 1) goto L5;
            String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L7:
            if (r10 == 1) goto L9;
            int r12 = 3;
        L10:
            Object[] r13 = new Object[r12];
            if (r10 == 1) goto L13;
            r13[0] = "result";
        L14:
            if (r10 == 1) goto L16;
            r13[1] = "kotlin/reflect/jvm/internal/impl/utils/DFS$CollectingNodeHandler";
        L17:
            if (r10 == 1) goto L19;
            r13[2] = "<init>";
        L19:
            String r14 = String.format(r11, r13);
            if (r10 == 1) goto L23;
            throw new IllegalArgumentException(r14);
        L23:
            throw new IllegalStateException(r14);
        L16:
            r13[1] = "result";
            goto L17
        L13:
            r13[0] = "kotlin/reflect/jvm/internal/impl/utils/DFS$CollectingNodeHandler";
            goto L14
        L9:
            r12 = 2;
            goto L10
        L5:
            r11 = "@NotNull method %s.%s must not return null";
            goto L7
        }

        protected CollectingNodeHandler(C r10) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            this.result = r10;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
        public C result() {
            C r10 = this.result;
            if (r10 != null) goto L5;
            $$$reportNull$$$0(1);
        L5:
            return r10;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
        public /* bridge */ /* synthetic */ Object result() {
            return result();
        }
    }

    public interface Neighbors<N> {
        Iterable<? extends N> getNeighbors(N r10);
    }

    public interface NodeHandler<N, R> {
        void afterChildren(N r10);

        boolean beforeChildren(N r10);

        R result();
    }

    public static abstract class NodeHandlerWithListResult<N, R> extends CollectingNodeHandler<N, R, LinkedList<R>> {
        protected NodeHandlerWithListResult() {
            super(new LinkedList());
        }
    }

    public interface Visited<N> {
        boolean checkAndMarkVisited(N r10);
    }

    public static class VisitedWithSet<N> implements Visited<N> {
        private final Set<N> visited;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"visited", "kotlin/reflect/jvm/internal/impl/utils/DFS$VisitedWithSet", "<init>"}));
        }

        public VisitedWithSet() {
            this(new HashSet());
        }

        public VisitedWithSet(Set<N> r10) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            this.visited = r10;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Visited
        public boolean checkAndMarkVisited(N r10) {
            return this.visited.add(r10);
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        Object[] r11 = new Object[3];
        switch(r10) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L4;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L4;
            case 8: goto L10;
            case 9: goto L7;
            case 10: goto L6;
            case 11: goto L10;
            case 12: goto L9;
            case 13: goto L8;
            case 14: goto L6;
            case 15: goto L10;
            case 16: goto L9;
            case 17: goto L4;
            case 18: goto L10;
            case 19: goto L9;
            case 20: goto L4;
            case 21: goto L10;
            case 22: goto L5;
            case 23: goto L10;
            case 24: goto L9;
            case 25: goto L8;
            default: goto L4;
        };
    L4:
        r11[0] = "nodes";
    L11:
        r11[1] = "kotlin/reflect/jvm/internal/impl/utils/DFS";
        switch(r10) {
            case 7: goto L17;
            case 8: goto L17;
            case 9: goto L17;
            case 10: goto L16;
            case 11: goto L16;
            case 12: goto L16;
            case 13: goto L16;
            case 14: goto L16;
            case 15: goto L16;
            case 16: goto L16;
            case 17: goto L15;
            case 18: goto L15;
            case 19: goto L15;
            case 20: goto L15;
            case 21: goto L15;
            case 22: goto L14;
            case 23: goto L14;
            case 24: goto L14;
            case 25: goto L14;
            default: goto L13;
        };
    L13:
        r11[2] = "dfs";
    L19:
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r11));
    L14:
        r11[2] = "doDfs";
        goto L19
    L15:
        r11[2] = "topologicalOrder";
        goto L19
    L16:
        r11[2] = "dfsFromNode";
        goto L19
    L17:
        r11[2] = "ifAny";
        goto L19
    L5:
        r11[0] = "current";
        goto L11
    L6:
        r11[0] = "node";
        goto L11
    L7:
        r11[0] = "predicate";
        goto L11
    L8:
        r11[0] = "handler";
        goto L11
    L9:
        r11[0] = "visited";
        goto L11
    L10:
        r11[0] = "neighbors";
        goto L11
    }

    public static <N, R> R dfs(Collection<N> r10, Neighbors<N> r11, NodeHandler<N, R> r12) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(4);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(5);
    L6:
        if (r12 != null) goto L9;
        $$$reportNull$$$0(6);
    L9:
        return (R) dfs(r10, r11, new VisitedWithSet(), r12);
    }

    public static <N, R> R dfs(Collection<N> r10, Neighbors<N> r11, Visited<N> r12, NodeHandler<N, R> r13) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r12 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r13 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        Iterator<N> r14 = r10.iterator();
    L12:
        if (r14.hasNext() == false) goto L15;
        doDfs(r14.next(), r11, r12, r13);
        goto L12
    L15:
        return r13.result();
    }

    public static <N> void doDfs(N r10, Neighbors<N> r11, Visited<N> r12, NodeHandler<N, ?> r13) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(22);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(23);
    L6:
        if (r12 != null) goto L8;
        $$$reportNull$$$0(24);
    L8:
        if (r13 != null) goto L11;
        $$$reportNull$$$0(25);
    L11:
        if (r12.checkAndMarkVisited(r10) == true) goto L14;
        return;
    L14:
        if (r13.beforeChildren(r10) == true) goto L16;
        return;
    L16:
        Iterator<? extends N> r14 = r11.getNeighbors(r10).iterator();
    L18:
        if (r14.hasNext() == false) goto L20;
        doDfs(r14.next(), r11, r12, r13);
        goto L18
    L20:
        r13.afterChildren(r10);
    }

    public static <N> Boolean ifAny(Collection<N> r10, Neighbors<N> r11, final Function1<N, Boolean> r12) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(7);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(8);
    L6:
        if (r12 != null) goto L8;
        $$$reportNull$$$0(9);
    L8:
        final boolean[] r13 = new boolean[1];
        return (Boolean) dfs(r10, r11, new AnonymousClass1(r12, r13));
    }
}
