package com.tom_roush.pdfbox.pdmodel.interactive.form;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes6.dex */
public final class FieldUtils {

    static class KeyValueKeyComparator implements Serializable, Comparator<a> {
        private static final long serialVersionUID = 6715364290007167694L;

        KeyValueKeyComparator() {
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(a r1, a r2) {
            return a.a(r1).compareTo(a.a(r2));
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(a r3, a r4) {
            return compare2((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"), (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.memorydata.plugin"));
        }
    }

    static class KeyValueValueComparator implements Serializable, Comparator<a> {
        private static final long serialVersionUID = -3984095679894798265L;

        KeyValueValueComparator() {
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(a r1, a r2) {
            return a.b(r1).compareTo(a.b(r2));
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(a r3, a r4) {
            return compare2((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"), (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.memorydata.plugin"));
        }
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f16293a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f16294b;

        static /* synthetic */ String a(a r0) {
            return r0.f16293a;
        }

        static /* synthetic */ String b(a r0) {
            return r0.f16294b;
        }

        public String toString() {
            return "(" + this.f16293a + ", " + this.f16294b + ")";
        }
    }
}
