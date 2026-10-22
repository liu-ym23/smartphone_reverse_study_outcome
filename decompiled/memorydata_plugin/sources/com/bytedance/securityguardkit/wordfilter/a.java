package com.bytedance.securityguardkit.wordfilter;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C0164a f3168a;

    /* JADX INFO: renamed from: com.bytedance.securityguardkit.wordfilter.a$a, reason: collision with other inner class name */
    private class C0164a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f3169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map<Character, C0164a> f3170b;
        private C0164a c;
        private boolean d;
        private String e;
        private String f;

        public C0164a(a r2) {
            this.f3169a = r2;
            this.f3170b = new HashMap();
            this.c = null;
            this.d = false;
            this.e = null;
            this.f = null;
        }

        public Map<Character, C0164a> a() {
            return this.f3170b;
        }

        public void a(C0164a r1) {
            this.c = r1;
        }

        public void a(String r1) {
            this.e = r1;
        }

        public void a(boolean r1) {
            this.d = r1;
        }

        public C0164a b() {
            return this.c;
        }

        public void b(String r1) {
            this.f = r1;
        }

        public boolean c() {
            return this.d;
        }

        public String d() {
            return this.e;
        }

        public String e() {
            return this.f;
        }
    }

    public a() {
        this.f3168a = new C0164a(this);
    }

    private void a() {
        LinkedList r0 = new LinkedList();
        Iterator<C0164a> r1 = this.f3168a.a().values().iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        C0164a r2 = (C0164a) ZeusTransformUtils.preCheckCast(r1.next(), C0164a.class, "com.obric.memorydata.plugin");
        r2.a(this.f3168a);
        r0.add(r2);
    L7:
        if (r0.isEmpty() == true) goto L20;
        C0164a r3 = (C0164a) ZeusTransformUtils.preCheckCast(r0.poll(), C0164a.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<Character, C0164a>> r4 = r3.a().entrySet().iterator();
    L10:
        if (r4.hasNext() == false) goto L7;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        char r6 = ((Character) ZeusTransformUtils.preCheckCast(r5.getKey(), Character.class, "com.obric.memorydata.plugin")).charValue();
        C0164a r7 = (C0164a) ZeusTransformUtils.preCheckCast(r5.getValue(), C0164a.class, "com.obric.memorydata.plugin");
        C0164a r8 = r3.b();
    L12:
        if (r8 == null) goto L16;
        if (r8.a().containsKey(Character.valueOf(r6)) == true) goto L16;
        r8 = r8.b();
    L16:
        if (r8 == null) goto L18;
        C0164a r9 = (C0164a) ZeusTransformUtils.preCheckCast(r8.a().getOrDefault(Character.valueOf(r6), this.f3168a), C0164a.class, "com.obric.memorydata.plugin");
    L19:
        r7.a(r9);
        r0.add(r7);
        goto L10
    L18:
        r9 = this.f3168a;
        goto L19
    }

    private void a(String r9, String r10) {
        C0164a r0 = this.f3168a;
        char[] r1 = r9.toCharArray();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        char r4 = r1[r3];
        r0.a().putIfAbsent(Character.valueOf(r4), new C0164a(this));
        r0 = (C0164a) ZeusTransformUtils.preCheckCast(r0.a().get(Character.valueOf(r4)), C0164a.class, "com.obric.memorydata.plugin");
        r3 = r3 + 1;
        goto L3
    L5:
        r0.a(true);
        r0.a(r9);
        r0.b(r10);
    }

    private boolean a(char r1) {
        if (r1 != ' ') goto L5;
    L12:
        return true;
    L5:
        if (r1 < '0') goto L9;
        if (r1 <= '9') goto L12;
    L9:
        if ("!@#$%^&*()_+-=[]{}|;:'\",.<>/?~·！@#￥%……&*（）——+-=【】{}|；：‘’“”，。《》？、".contains(String.valueOf(r1)) == true) goto L12;
        return false;
    }

    public Map<String, String> a(String r8) {
        HashMap r0 = new HashMap();
        C0164a r1 = this.f3168a;
        char[] r9 = r8.toCharArray();
        int r2 = r9.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L22;
        char r4 = r9[r3];
        if (a(r4) == true) goto L21;
    L7:
        if (r1 == null) goto L11;
        if (r1.a().containsKey(Character.valueOf(r4)) == true) goto L11;
        r1 = r1.b();
    L11:
        if (r1 != null) goto L13;
        r1 = this.f3168a;
    L14:
        C0164a r5 = r1;
    L16:
        if (r5 == this.f3168a) goto L21;
        if (r5.c() == false) goto L20;
        r0.put(r5.d(), r5.e());
    L20:
        r5 = r5.b();
        goto L16
    L13:
        r1 = (C0164a) ZeusTransformUtils.preCheckCast(r1.a().getOrDefault(Character.valueOf(r4), this.f3168a), C0164a.class, "com.obric.memorydata.plugin");
    L21:
        r3 = r3 + 1;
        goto L3
    L22:
        return r0;
    }

    public void a(Map<String, Set<String>> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.isEmpty() == true) goto L19;
        Iterator r8 = r7.entrySet().iterator();
    L9:
        if (r8.hasNext() == false) goto L14;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin");
        Iterator r1 = ((Set) ZeusTransformUtils.preCheckCast(r0.getValue(), Set.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r1.hasNext() == false) goto L9;
        a((String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin"), r2);
        goto L12
    L14:
        a();
        return;
    }

    public Set<String> b(String r1) {
        return new HashSet(a(r1).values());
    }
}
