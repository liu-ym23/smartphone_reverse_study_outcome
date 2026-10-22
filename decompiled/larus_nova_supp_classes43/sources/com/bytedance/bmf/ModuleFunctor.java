package com.bytedance.bmf;

import com.bytedance.hmp.Ptr;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class ModuleFunctor extends Ptr {
    boolean cleanup;
    Class[] inputTypes;
    Class[] outputTypes;

    public void free() {
        if (((Ptr) this).own == false) goto L6;
        API.bmf_module_functor_free(((Ptr) this).ptr);
        return;
    }

    public Packet[] _inputs(Object[] r11) throws Exception {
        if (r11 == null) goto L4;
        int r0 = r11.length;
        Class[] r1 = this.inputTypes;
        int r10 = 0;
        if (r0 != r1.length) goto L30;
        int r12 = r1.length;
        Packet[] r13 = new Packet[r12];
        int r14 = 0;
    L31:
    L22:
        e = move-exception;
    L23:
        if (r10 >= r12) goto L28;
        Packet r15 = r13[r10];
        if (r15 == null) goto L27;
        r15.free();
    L27:
        r10 = r10 + 1;
        goto L23
    L28:
        throw e;
    L9:
        if (r14 >= r11.length) goto L21;
        Object r16 = r11[r14];     // Catch: Exception -> L22
        if (r16 == null) goto L19;
        Class r17 = this.inputTypes[r14];     // Catch: Exception -> L22
        if (r17 == null) goto L19;
        if (r17.isInstance(r16) == true) goto L19;
        throw new IllegalArgumentException(String.format("Expect input type %s at %d, got %s", new Object[]{this.inputTypes[r14].getName(), Integer.valueOf(r14), r11[r14].getClass().getName()}));     // Catch: Exception -> L22
    L19:
        r13[r14] = new Packet(r11[r14]);     // Catch: Exception -> L22
        r14 = r14 + 1;
        goto L31
    L21:
        return r13;
    L30:
        throw new IllegalArgumentException(String.format("Expect %d inputs, got %d", new Object[]{Integer.valueOf(this.inputTypes.length), Integer.valueOf(r11.length)}));
    L4:
        return new Packet[this.inputTypes.length];
    }

    public Object[] call(Object... r13) throws Exception {
        Packet[] r14 = _inputs(r13);
        int r0 = this.outputTypes.length;
        Packet[] r1 = new Packet[r0];
        int r10 = 0;
        long[] r11 = new long[r14.length];     // Catch: Throwable -> L50
        int r12 = 0;
    L5:
        if (r12 >= r14.length) goto L7;
        r11[r12] = r14[r12].getPtr();     // Catch: Throwable -> L50
        r12 = r12 + 1;     // Catch: Throwable -> L50
        goto L5
    L7:
        long[] r15 = API.bmf_module_functor_call(((Ptr) this).ptr, r11);     // Catch: Throwable -> L50
        if (r15 == null) goto L49;
        if (r15.length == this.outputTypes.length) goto L17;
        int r16 = 0;
    L13:
        if (r16 >= r15.length) goto L16;
        API.bmf_packet_free(r15[r16]);     // Catch: Throwable -> L50
        r16 = r16 + 1;     // Catch: Throwable -> L50
        goto L13
    L16:
        throw new IllegalStateException(String.format("Expect %d outputs, got %d", new Object[]{Integer.valueOf(this.outputTypes.length), Integer.valueOf(r15.length)}));     // Catch: Throwable -> L50
    L17:
        int r17 = 0;
    L19:
        if (r17 >= r15.length) goto L21;
        r1[r17] = Packet.wrap(r15[r17], true);     // Catch: Throwable -> L50
        r17 = r17 + 1;     // Catch: Throwable -> L50
        goto L19
    L21:
        int r18 = 0;
    L22:
        if (r18 >= r0) goto L33;
        if (r1[r18].getPtr() == 0) goto L32;
        Class r19 = this.outputTypes[r18];     // Catch: Throwable -> L50
        if (r19 == null) goto L32;
        if (r1[r18].is(r19) == true) goto L32;
        throw new IllegalStateException(String.format("Invalid output packet type at port %d, expect %s", new Object[]{Integer.valueOf(r18), this.outputTypes[r18].getName()}));     // Catch: Throwable -> L50
    L32:
        r18 = r18 + 1;     // Catch: Throwable -> L50
        goto L22
    L33:
        Object[] r20 = new Object[r15.length];     // Catch: Throwable -> L50
        int r21 = 0;
    L35:
        if (r21 >= r15.length) goto L38;
        r20[r21] = _output(r1[r21], r21);     // Catch: Throwable -> L50
        r21 = r21 + 1;
        goto L35
    L38:
        int r22 = 0;
    L40:
        if (r22 >= r14.length) goto L42;
        r14[r22].free();
        r22 = r22 + 1;
    L42:
        if (r10 >= r0) goto L47;
        Packet r110 = r1[r10];
        if (r110 == null) goto L46;
        r110.free();
    L46:
        r10 = r10 + 1;
        goto L42
    L47:
        return r20;
    L49:
        throw new IllegalStateException("output pkt (opktPtrs) is null");     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L63
        int r23 = 0;
    L54:
        if (r23 >= r14.length) goto L56;
        r14[r23].free();
        r23 = r23 + 1;
    L56:
        if (r10 >= r0) goto L61;
        Packet r111 = r1[r10];
        if (r111 == null) goto L60;
        r111.free();
    L60:
        r10 = r10 + 1;
        goto L56
    L61:
        return null;
    L63:
        th = move-exception;
        int r24 = 0;
    L66:
        if (r24 >= r14.length) goto L68;
        r14[r24].free();
        r24 = r24 + 1;
    L68:
        if (r10 >= r0) goto L73;
        Packet r112 = r1[r10];
        if (r112 == null) goto L72;
        r112.free();
    L72:
        r10 = r10 + 1;
        goto L68
    L73:
        throw th;
    }

    public void execute(Object... r10) throws Exception {
        Packet[] r11 = _inputs(r10);
        int r0 = 0;
        long[] r1 = new long[r11.length];     // Catch: Throwable -> L12
        int r12 = 0;
    L5:
        if (r12 >= r11.length) goto L7;
        r1[r12] = r11[r12].getPtr();     // Catch: Throwable -> L12
        r12 = r12 + 1;     // Catch: Throwable -> L12
        goto L5
    L7:
        API.bmf_module_functor_execute(((Ptr) this).ptr, r1, this.cleanup);     // Catch: Throwable -> L12
    L9:
        if (r0 >= r11.length) goto L11;
        r11[r0].free();
        r0 = r0 + 1;
        goto L9
    L11:
        return;
    L12:
        th = move-exception;
    L14:
        if (r0 >= r11.length) goto L16;
        r11[r0].free();
        r0 = r0 + 1;
        goto L14
    L16:
        throw th;
    }

    public Object[] fetch(int r12) throws Exception {
        long[] r0 = API.bmf_module_functor_fetch(((Ptr) this).ptr, r12);
        int r1 = r0.length;
        Packet[] r10 = new Packet[r1];
        int r11 = 0;
        int r13 = 0;
    L4:
        if (r13 >= r0.length) goto L6;
        r10[r13] = Packet.wrap(r0[r13], true);
        r13 = r13 + 1;
        goto L4
    L6:
        int r14 = 0;
    L7:
        if (r14 >= r1) goto L18;
    L26:
        th = move-exception;
    L27:
        if (r11 >= r1) goto L29;
        r10[r11].free();
        r11 = r11 + 1;
        goto L27
    L29:
        throw th;
    L9:
        if (r10[r14].getPtr() == 0) goto L17;
        Class r15 = this.outputTypes[r12];     // Catch: Throwable -> L26
        if (r15 == null) goto L17;
        if (r10[r14].is(r15) == true) goto L17;
        throw new IllegalStateException(String.format("Invalid output packet type at %d from port %d, expect %s", new Object[]{Integer.valueOf(r14), Integer.valueOf(r12), this.outputTypes[r12].getName()}));     // Catch: Throwable -> L26
    L17:
        r14 = r14 + 1;     // Catch: Throwable -> L26
        goto L7
    L18:
        Object[] r16 = new Object[r0.length];     // Catch: Throwable -> L26
        int r17 = 0;
    L20:
        if (r17 >= r0.length) goto L23;
        r16[r17] = _output(r10[r17], r12);     // Catch: Throwable -> L26
        r17 = r17 + 1;
    L23:
        if (r11 >= r1) goto L25;
        r10[r11].free();
        r11 = r11 + 1;
        goto L23
    L25:
        return r16;
    }

    public ModuleFunctor(long r10, boolean r11) {
        this.cleanup = true;
        ((Ptr) this).ptr = r10;
        ((Ptr) this).own = r11;
    }

    public static ModuleFunctor wrap(long r1, boolean r10) {
        return new ModuleFunctor(r1, r10);
    }

    public Object _output(Packet r10, int r11) throws Exception {
        if (r10.getPtr() != 0) goto L6;
        return null;
    L6:
        Class r12 = this.outputTypes[r11];
        if (r12 != null) goto L10;
        return r10;
    L10:
        return r10.get(r12);
    }

    public ModuleFunctor(ModuleInfo r11, Object r12, Class[] r13, Class[] r14) {
        this.cleanup = true;
        String r10 = GsonProtectorUtils.toJson(new Gson(), r12);
        ((Ptr) this).ptr = API.bmf_module_functor_make(r11.name, r11.type, r11.path, r11.entry, r10, r13.length, r14.length, -1);
        ((Ptr) this).own = true;
        this.inputTypes = r13;
        this.outputTypes = r14;
    }

    public ModuleFunctor(ModuleInfo r1, Object r10, Class[] r11, Class[] r12, boolean r13) {
        this(r1, r10, r11, r12);
        this.cleanup = r13;
    }
}
