package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class m implements Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CodedOutputStream f5027a;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.m$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5028a = null;

        static {
            int[] r0 = new int[WireFormat.FieldType.values().length];
            f5028a = r0;
            r0[WireFormat.FieldType.BOOL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L30:
            f5028a[WireFormat.FieldType.FIXED32.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L36:
            f5028a[WireFormat.FieldType.INT32.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L50:
            f5028a[WireFormat.FieldType.SFIXED32.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L32:
            f5028a[WireFormat.FieldType.SINT32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L38:
            f5028a[WireFormat.FieldType.UINT32.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L42:
            f5028a[WireFormat.FieldType.FIXED64.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L46:
            f5028a[WireFormat.FieldType.INT64.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L28:
            f5028a[WireFormat.FieldType.SFIXED64.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L34:
            f5028a[WireFormat.FieldType.SINT64.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L40:
            f5028a[WireFormat.FieldType.UINT64.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L44:
            f5028a[WireFormat.FieldType.STRING.ordinal()] = 12;     // Catch: NoSuchFieldError -> L27
            return;
        }
    }

    private m(CodedOutputStream r3) {
        CodedOutputStream r4 = (CodedOutputStream) ZeusTransformUtils.preCheckCast(ab.a(r3, "output"), CodedOutputStream.class, "com.obric.memorydata.plugin");
        this.f5027a = r4;
        r4.f4903a = this;
    }

    public static m a(CodedOutputStream r1) {
        if (r1.f4903a == null) goto L7;
        return r1.f4903a;
    L7:
        return new m(r1);
    }

    private <V> void a(int r3, boolean r4, V r5, an.a<Boolean, V> r6) {
        this.f5027a.a(r3, 2);
        this.f5027a.c(an.a(r6, Boolean.valueOf(r4), r5));
        an.a(this.f5027a, r6, Boolean.valueOf(r4), r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> void b(int r3, an.a<K, V> r4, Map<K, V> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        switch(AnonymousClass1.f5028a[r4.f4960a.ordinal()]) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L7;
            case 9: goto L7;
            case 10: goto L7;
            case 11: goto L7;
            case 12: goto L6;
            default: goto L5;
        };
    L6:
        e(r3, r4, r6);
        return;
    L7:
        d(r3, r4, r6);
        return;
    L8:
        c(r3, r4, r6);
        return;
    L9:
        Object r0 = r6.get(Boolean.FALSE);
        if (r0 == null) goto L12;
        a(r3, false, r0, r4);
    L12:
        Object r7 = r6.get(Boolean.TRUE);
        if (r7 == null) goto L19;
        a(r3, true, r7, r4);
        return;
    L19:
        return;
    L5:
        throw new IllegalArgumentException("does not support key type: " + r4.f4960a);
    }

    private void b(int r3, Object r4) {
        boolean r0 = ZeusTransformUtils.instanceOf(r4, String.class);
        CodedOutputStream r2 = this.f5027a;
        if (r0 == false) goto L5;
        r2.a(r3, (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r2.a(r3, (ByteString) ZeusTransformUtils.preCheckCast(r4, ByteString.class, "com.obric.memorydata.plugin"));
    }

    private <V> void c(int r9, an.a<Integer, V> r10, Map<Integer, V> r11) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        int r0 = r12.size();
        int[] r2 = new int[r0];
        Iterator r3 = r12.keySet().iterator();
        int r4 = 0;
        int r5 = 0;
    L4:
        if (r3.hasNext() == false) goto L6;
        r2[r5] = ((Integer) ZeusTransformUtils.preCheckCast(r3.next(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        r5 = r5 + 1;
        goto L4
    L6:
        Arrays.sort(r2);
    L7:
        if (r4 >= r0) goto L9;
        int r1 = r2[r4];
        Object r6 = r12.get(Integer.valueOf(r1));
        this.f5027a.a(r9, 2);
        this.f5027a.c(an.a(r10, Integer.valueOf(r1), r6));
        an.a(this.f5027a, r10, Integer.valueOf(r1), r6);
        r4 = r4 + 1;
        goto L7
    }

    private <V> void d(int r10, an.a<Long, V> r11, Map<Long, V> r12) {
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        int r0 = r13.size();
        long[] r2 = new long[r0];
        Iterator r3 = r13.keySet().iterator();
        int r4 = 0;
        int r5 = 0;
    L4:
        if (r3.hasNext() == false) goto L6;
        r2[r5] = ((Long) ZeusTransformUtils.preCheckCast(r3.next(), Long.class, "com.obric.memorydata.plugin")).longValue();
        r5 = r5 + 1;
        goto L4
    L6:
        Arrays.sort(r2);
    L7:
        if (r4 >= r0) goto L9;
        long r6 = r2[r4];
        Object r1 = r13.get(Long.valueOf(r6));
        this.f5027a.a(r10, 2);
        this.f5027a.c(an.a(r11, Long.valueOf(r6), r1));
        an.a(this.f5027a, r11, Long.valueOf(r6), r1);
        r4 = r4 + 1;
        goto L7
    }

    private <V> void e(int r9, an.a<String, V> r10, Map<String, V> r11) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        int r0 = r12.size();
        String[] r2 = new String[r0];
        Iterator r3 = r12.keySet().iterator();
        int r4 = 0;
        int r5 = 0;
    L4:
        if (r3.hasNext() == false) goto L6;
        r2[r5] = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
        r5 = r5 + 1;
        goto L4
    L6:
        Arrays.sort(r2);
    L7:
        if (r4 >= r0) goto L9;
        String r1 = r2[r4];
        Object r6 = r12.get(r1);
        this.f5027a.a(r9, 2);
        this.f5027a.c(an.a(r10, r1, r6));
        an.a(this.f5027a, r10, r1, r6);
        r4 = r4 + 1;
        goto L7
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public Writer.FieldOrder a() {
        return Writer.FieldOrder.ASCENDING;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    @Deprecated
    public void a(int r2) {
        this.f5027a.a(r2, 3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void a(int r1, double r2) {
        this.f5027a.a(r1, r2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void a(int r1, float r2) {
        this.f5027a.a(r1, r2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void a(int r1, int r2) {
        this.f5027a.f(r1, r2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void a(int r1, long r2) {
        this.f5027a.a(r1, r2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void a(int r1, ByteString r2) {
        this.f5027a.a(r1, r2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public <K, V> void a(int r6, an.a<K, V> r7, Map<K, V> r8) {
        Map<K, V> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        if (this.f5027a.a() == false) goto L6;
        b(r6, r7, r9);
        return;
    L6:
        Iterator<Map.Entry<K, V>> r10 = r9.entrySet().iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        this.f5027a.a(r6, 2);
        this.f5027a.c(an.a(r7, r0.getKey(), r0.getValue()));
        an.a(this.f5027a, r7, r0.getKey(), r0.getValue());
        goto L8
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void a(int r3, Object r4) {
        boolean r0 = ZeusTransformUtils.instanceOf(r4, ByteString.class);
        CodedOutputStream r2 = this.f5027a;
        if (r0 == false) goto L5;
        r2.b(r3, (ByteString) ZeusTransformUtils.preCheckCast(r4, ByteString.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r2.a(r3, (at) ZeusTransformUtils.preCheckCast(r4, at.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void a(int r3, Object r4, bl r5) {
        bl r6 = (bl) ZeusTransformUtils.wrapperContextForParams(r5, bl.class, "com.obric.memorydata.plugin");
        this.f5027a.a(r3, (at) ZeusTransformUtils.preCheckCast(r4, at.class, "com.obric.memorydata.plugin"), r6);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void a(int r1, String r2) {
        this.f5027a.a(r1, r2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void a(int r6, List<String> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        int r2 = 0;
        if (ZeusTransformUtils.instanceOf(r8, ah.class) == false) goto L9;
        ah r0 = (ah) ZeusTransformUtils.preCheckCast(r8, ah.class, "com.obric.memorydata.plugin");
    L6:
        if (r2 >= r8.size()) goto L11;
        b(r6, r0.d(r2));
        r2 = r2 + 1;
        goto L6
    L11:
        return;
    L9:
        if (r2 >= r8.size()) goto L14;
        this.f5027a.a(r6, (String) ZeusTransformUtils.preCheckCast(r8.get(r2), String.class, "com.obric.memorydata.plugin"));
        r2 = r2 + 1;
        goto L9
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void a(int r3, List<?> r4, bl r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        bl r7 = (bl) ZeusTransformUtils.wrapperContextForParams(r5, bl.class, "com.obric.memorydata.plugin");
        int r0 = 0;
    L4:
        if (r0 >= r6.size()) goto L6;
        a(r3, r6.get(r0), r7);
        r0 = r0 + 1;
        goto L4
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void a(int r5, List<Integer> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        if (r7 == false) goto L13;
        this.f5027a.a(r5, 2);
        int r9 = 0;
        int r10 = 0;
    L6:
        if (r9 >= r8.size()) goto L8;
        r10 = r10 + CodedOutputStream.i(((Integer) ZeusTransformUtils.preCheckCast(r8.get(r9), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r9 = r9 + 1;
        goto L6
    L8:
        this.f5027a.c(r10);
    L10:
        if (r0 >= r8.size()) goto L15;
        this.f5027a.b(((Integer) ZeusTransformUtils.preCheckCast(r8.get(r0), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r8.size()) goto L19;
        this.f5027a.b(r5, ((Integer) ZeusTransformUtils.preCheckCast(r8.get(r0), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void a(int r1, boolean r2) {
        this.f5027a.a(r1, r2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    @Deprecated
    public void b(int r2) {
        this.f5027a.a(r2, 4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void b(int r1, int r2) {
        this.f5027a.g(r1, r2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void b(int r1, long r2) {
        this.f5027a.e(r1, r2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void b(int r3, Object r4, bl r5) {
        bl r6 = (bl) ZeusTransformUtils.wrapperContextForParams(r5, bl.class, "com.obric.memorydata.plugin");
        this.f5027a.c(r3, (at) ZeusTransformUtils.preCheckCast(r4, at.class, "com.obric.memorydata.plugin"), r6);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void b(int r6, List<ByteString> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        int r0 = 0;
    L4:
        if (r0 >= r8.size()) goto L6;
        this.f5027a.a(r6, (ByteString) ZeusTransformUtils.preCheckCast(r8.get(r0), ByteString.class, "com.obric.memorydata.plugin"));
        r0 = r0 + 1;
        goto L4
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void b(int r3, List<?> r4, bl r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        bl r7 = (bl) ZeusTransformUtils.wrapperContextForParams(r5, bl.class, "com.obric.memorydata.plugin");
        int r0 = 0;
    L4:
        if (r0 >= r6.size()) goto L6;
        b(r3, r6.get(r0), r7);
        r0 = r0 + 1;
        goto L4
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void b(int r5, List<Integer> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        if (r7 == false) goto L13;
        this.f5027a.a(r5, 2);
        int r9 = 0;
        int r10 = 0;
    L6:
        if (r9 >= r8.size()) goto L8;
        r10 = r10 + CodedOutputStream.l(((Integer) ZeusTransformUtils.preCheckCast(r8.get(r9), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r9 = r9 + 1;
        goto L6
    L8:
        this.f5027a.c(r10);
    L10:
        if (r0 >= r8.size()) goto L15;
        this.f5027a.e(((Integer) ZeusTransformUtils.preCheckCast(r8.get(r0), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r8.size()) goto L19;
        this.f5027a.e(r5, ((Integer) ZeusTransformUtils.preCheckCast(r8.get(r0), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void c(int r1, int r2) {
        this.f5027a.b(r1, r2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void c(int r1, long r2) {
        this.f5027a.b(r1, r2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void c(int r5, List<Long> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        if (r7 == false) goto L13;
        this.f5027a.a(r5, 2);
        int r9 = 0;
        int r10 = 0;
    L6:
        if (r9 >= r8.size()) goto L8;
        r10 = r10 + CodedOutputStream.f(((Long) ZeusTransformUtils.preCheckCast(r8.get(r9), Long.class, "com.obric.memorydata.plugin")).longValue());
        r9 = r9 + 1;
        goto L6
    L8:
        this.f5027a.c(r10);
    L10:
        if (r0 >= r8.size()) goto L15;
        this.f5027a.a(((Long) ZeusTransformUtils.preCheckCast(r8.get(r0), Long.class, "com.obric.memorydata.plugin")).longValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r8.size()) goto L19;
        this.f5027a.a(r5, ((Long) ZeusTransformUtils.preCheckCast(r8.get(r0), Long.class, "com.obric.memorydata.plugin")).longValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void d(int r1, int r2) {
        this.f5027a.e(r1, r2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void d(int r1, long r2) {
        this.f5027a.d(r1, r2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void d(int r5, List<Long> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        if (r7 == false) goto L13;
        this.f5027a.a(r5, 2);
        int r9 = 0;
        int r10 = 0;
    L6:
        if (r9 >= r8.size()) goto L8;
        r10 = r10 + CodedOutputStream.g(((Long) ZeusTransformUtils.preCheckCast(r8.get(r9), Long.class, "com.obric.memorydata.plugin")).longValue());
        r9 = r9 + 1;
        goto L6
    L8:
        this.f5027a.c(r10);
    L10:
        if (r0 >= r8.size()) goto L15;
        this.f5027a.b(((Long) ZeusTransformUtils.preCheckCast(r8.get(r0), Long.class, "com.obric.memorydata.plugin")).longValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r8.size()) goto L19;
        this.f5027a.b(r5, ((Long) ZeusTransformUtils.preCheckCast(r8.get(r0), Long.class, "com.obric.memorydata.plugin")).longValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void e(int r1, int r2) {
        this.f5027a.c(r1, r2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void e(int r1, long r2) {
        this.f5027a.c(r1, r2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void e(int r5, List<Long> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        if (r7 == false) goto L13;
        this.f5027a.a(r5, 2);
        int r9 = 0;
        int r10 = 0;
    L6:
        if (r9 >= r8.size()) goto L8;
        r10 = r10 + CodedOutputStream.i(((Long) ZeusTransformUtils.preCheckCast(r8.get(r9), Long.class, "com.obric.memorydata.plugin")).longValue());
        r9 = r9 + 1;
        goto L6
    L8:
        this.f5027a.c(r10);
    L10:
        if (r0 >= r8.size()) goto L15;
        this.f5027a.d(((Long) ZeusTransformUtils.preCheckCast(r8.get(r0), Long.class, "com.obric.memorydata.plugin")).longValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r8.size()) goto L19;
        this.f5027a.d(r5, ((Long) ZeusTransformUtils.preCheckCast(r8.get(r0), Long.class, "com.obric.memorydata.plugin")).longValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void f(int r1, int r2) {
        this.f5027a.d(r1, r2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void f(int r5, List<Float> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        if (r7 == false) goto L13;
        this.f5027a.a(r5, 2);
        int r9 = 0;
        int r10 = 0;
    L6:
        if (r9 >= r8.size()) goto L8;
        r10 = r10 + CodedOutputStream.b(((Float) ZeusTransformUtils.preCheckCast(r8.get(r9), Float.class, "com.obric.memorydata.plugin")).floatValue());
        r9 = r9 + 1;
        goto L6
    L8:
        this.f5027a.c(r10);
    L10:
        if (r0 >= r8.size()) goto L15;
        this.f5027a.a(((Float) ZeusTransformUtils.preCheckCast(r8.get(r0), Float.class, "com.obric.memorydata.plugin")).floatValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r8.size()) goto L19;
        this.f5027a.a(r5, ((Float) ZeusTransformUtils.preCheckCast(r8.get(r0), Float.class, "com.obric.memorydata.plugin")).floatValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void g(int r5, List<Double> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        if (r7 == false) goto L13;
        this.f5027a.a(r5, 2);
        int r9 = 0;
        int r10 = 0;
    L6:
        if (r9 >= r8.size()) goto L8;
        r10 = r10 + CodedOutputStream.b(((Double) ZeusTransformUtils.preCheckCast(r8.get(r9), Double.class, "com.obric.memorydata.plugin")).doubleValue());
        r9 = r9 + 1;
        goto L6
    L8:
        this.f5027a.c(r10);
    L10:
        if (r0 >= r8.size()) goto L15;
        this.f5027a.a(((Double) ZeusTransformUtils.preCheckCast(r8.get(r0), Double.class, "com.obric.memorydata.plugin")).doubleValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r8.size()) goto L19;
        this.f5027a.a(r5, ((Double) ZeusTransformUtils.preCheckCast(r8.get(r0), Double.class, "com.obric.memorydata.plugin")).doubleValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void h(int r5, List<Integer> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        if (r7 == false) goto L13;
        this.f5027a.a(r5, 2);
        int r9 = 0;
        int r10 = 0;
    L6:
        if (r9 >= r8.size()) goto L8;
        r10 = r10 + CodedOutputStream.n(((Integer) ZeusTransformUtils.preCheckCast(r8.get(r9), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r9 = r9 + 1;
        goto L6
    L8:
        this.f5027a.c(r10);
    L10:
        if (r0 >= r8.size()) goto L15;
        this.f5027a.g(((Integer) ZeusTransformUtils.preCheckCast(r8.get(r0), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r8.size()) goto L19;
        this.f5027a.g(r5, ((Integer) ZeusTransformUtils.preCheckCast(r8.get(r0), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void i(int r5, List<Boolean> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        if (r7 == false) goto L13;
        this.f5027a.a(r5, 2);
        int r9 = 0;
        int r10 = 0;
    L6:
        if (r9 >= r8.size()) goto L8;
        r10 = r10 + CodedOutputStream.b(((Boolean) ZeusTransformUtils.preCheckCast(r8.get(r9), Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        r9 = r9 + 1;
        goto L6
    L8:
        this.f5027a.c(r10);
    L10:
        if (r0 >= r8.size()) goto L15;
        this.f5027a.a(((Boolean) ZeusTransformUtils.preCheckCast(r8.get(r0), Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r8.size()) goto L19;
        this.f5027a.a(r5, ((Boolean) ZeusTransformUtils.preCheckCast(r8.get(r0), Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void j(int r5, List<Integer> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        if (r7 == false) goto L13;
        this.f5027a.a(r5, 2);
        int r9 = 0;
        int r10 = 0;
    L6:
        if (r9 >= r8.size()) goto L8;
        r10 = r10 + CodedOutputStream.j(((Integer) ZeusTransformUtils.preCheckCast(r8.get(r9), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r9 = r9 + 1;
        goto L6
    L8:
        this.f5027a.c(r10);
    L10:
        if (r0 >= r8.size()) goto L15;
        this.f5027a.c(((Integer) ZeusTransformUtils.preCheckCast(r8.get(r0), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r8.size()) goto L19;
        this.f5027a.c(r5, ((Integer) ZeusTransformUtils.preCheckCast(r8.get(r0), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void k(int r5, List<Integer> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        if (r7 == false) goto L13;
        this.f5027a.a(r5, 2);
        int r9 = 0;
        int r10 = 0;
    L6:
        if (r9 >= r8.size()) goto L8;
        r10 = r10 + CodedOutputStream.m(((Integer) ZeusTransformUtils.preCheckCast(r8.get(r9), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r9 = r9 + 1;
        goto L6
    L8:
        this.f5027a.c(r10);
    L10:
        if (r0 >= r8.size()) goto L15;
        this.f5027a.f(((Integer) ZeusTransformUtils.preCheckCast(r8.get(r0), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r8.size()) goto L19;
        this.f5027a.f(r5, ((Integer) ZeusTransformUtils.preCheckCast(r8.get(r0), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void l(int r5, List<Long> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        if (r7 == false) goto L13;
        this.f5027a.a(r5, 2);
        int r9 = 0;
        int r10 = 0;
    L6:
        if (r9 >= r8.size()) goto L8;
        r10 = r10 + CodedOutputStream.j(((Long) ZeusTransformUtils.preCheckCast(r8.get(r9), Long.class, "com.obric.memorydata.plugin")).longValue());
        r9 = r9 + 1;
        goto L6
    L8:
        this.f5027a.c(r10);
    L10:
        if (r0 >= r8.size()) goto L15;
        this.f5027a.e(((Long) ZeusTransformUtils.preCheckCast(r8.get(r0), Long.class, "com.obric.memorydata.plugin")).longValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r8.size()) goto L19;
        this.f5027a.e(r5, ((Long) ZeusTransformUtils.preCheckCast(r8.get(r0), Long.class, "com.obric.memorydata.plugin")).longValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void m(int r5, List<Integer> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        if (r7 == false) goto L13;
        this.f5027a.a(r5, 2);
        int r9 = 0;
        int r10 = 0;
    L6:
        if (r9 >= r8.size()) goto L8;
        r10 = r10 + CodedOutputStream.k(((Integer) ZeusTransformUtils.preCheckCast(r8.get(r9), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r9 = r9 + 1;
        goto L6
    L8:
        this.f5027a.c(r10);
    L10:
        if (r0 >= r8.size()) goto L15;
        this.f5027a.d(((Integer) ZeusTransformUtils.preCheckCast(r8.get(r0), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r8.size()) goto L19;
        this.f5027a.d(r5, ((Integer) ZeusTransformUtils.preCheckCast(r8.get(r0), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void n(int r5, List<Long> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        if (r7 == false) goto L13;
        this.f5027a.a(r5, 2);
        int r9 = 0;
        int r10 = 0;
    L6:
        if (r9 >= r8.size()) goto L8;
        r10 = r10 + CodedOutputStream.h(((Long) ZeusTransformUtils.preCheckCast(r8.get(r9), Long.class, "com.obric.memorydata.plugin")).longValue());
        r9 = r9 + 1;
        goto L6
    L8:
        this.f5027a.c(r10);
    L10:
        if (r0 >= r8.size()) goto L15;
        this.f5027a.c(((Long) ZeusTransformUtils.preCheckCast(r8.get(r0), Long.class, "com.obric.memorydata.plugin")).longValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r8.size()) goto L19;
        this.f5027a.c(r5, ((Long) ZeusTransformUtils.preCheckCast(r8.get(r0), Long.class, "com.obric.memorydata.plugin")).longValue());
        r0 = r0 + 1;
        goto L13
    }
}
