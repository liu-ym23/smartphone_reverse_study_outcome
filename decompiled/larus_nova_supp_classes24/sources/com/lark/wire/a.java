package com.lark.wire;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements h0 {
    public final byte[] a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public FieldEncoding h;
    public final List<Buffer> i;
    public i0 j;

    @Override // com.lark.wire.h0
    public final boolean a() {
        int r0 = this.e;
        if (r0 == 0) goto L17;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 == 2) goto L13;
        if (r0 != 5) goto L11;
        return true;
    L11:
        throw new ProtocolException("unexpected state: " + this.e);
    L13:
        if (this.b < this.c) goto L20;
        this.c = this.g;
        this.g = -1;
        this.e = 6;
        return false;
    L20:
        return true;
    L17:
        return true;
    }

    @Override // com.lark.wire.h0
    public final void b() {
        int r0 = this.e;
        if (r0 != 0) goto L5;
        l();
        return;
    L5:
        if (r0 != 1) goto L7;
        g();
        return;
    L7:
        if (r0 != 2) goto L9;
        int r1 = o();
        int r2 = this.b + r1;
        if (r2 > this.c) goto L17;
        this.b = r2;
        return;
    L17:
        throw new EOFException();
    L9:
        if (r0 != 5) goto L12;
        d();
        return;
    L12:
        throw new IllegalStateException("Unexpected call to skip()");
    }

    @Override // com.lark.wire.h0
    public final int c() {
        int r0 = this.e;
        if (r0 != 0) goto L5;
    L9:
        int r1 = p();
        n(0);
        return r1;
    L5:
        if (r0 == 2) goto L9;
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.e);
    }

    @Override // com.lark.wire.h0
    public final int d() {
        int r0 = this.e;
        if (r0 != 5) goto L5;
    L9:
        int r1 = this.b;
        if ((r1 + 4) > this.c) goto L14;
        byte[] r2 = this.a;
        int r3 = r1 + 1;
        int r4 = r3 + 1;
        int r5 = (r2[r1] & 255) | ((r2[r3] & 255) << 8);
        int r6 = r4 + 1;
        int r7 = r5 | ((r2[r4] & 255) << 16);
        this.b = r6 + 1;
        int r8 = r7 | ((r2[r6] & 255) << 24);
        n(5);
        return r8;
    L14:
        throw new EOFException();
    L5:
        if (r0 == 2) goto L9;
        throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.e);
    }

    @Override // com.lark.wire.h0
    public final long g() {
        int r0 = this.e;
        if (r0 != 1) goto L5;
    L9:
        int r1 = this.b;
        if ((r1 + 8) > this.c) goto L14;
        byte[] r2 = this.a;
        int r3 = r1 + 1;
        long r4 = ((long) r2[r1]) & 255;
        int r5 = r3 + 1;
        int r6 = r5 + 1;
        long r7 = (r4 | ((((long) r2[r3]) & 255) << 8)) | ((((long) r2[r5]) & 255) << 16);
        int r8 = r6 + 1;
        long r9 = r7 | ((((long) r2[r6]) & 255) << 24);
        int r10 = r8 + 1;
        long r11 = r9 | ((((long) r2[r8]) & 255) << 32);
        int r12 = r10 + 1;
        long r13 = r11 | ((((long) r2[r10]) & 255) << 40);
        int r14 = r12 + 1;
        long r15 = r13 | ((((long) r2[r12]) & 255) << 48);
        this.b = r14 + 1;
        long r16 = ((((long) r2[r14]) & 255) << 56) | r15;
        n(1);
        return r16;
    L14:
        throw new EOFException();
    L5:
        if (r0 == 2) goto L9;
        throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.e);
    }

    @Override // com.lark.wire.h0
    public final int h() {
        if (this.e != 2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L17;
        int r1 = this.d + 1;
        this.d = r1;
        if (r1 > 100) goto L15;
        if (r1 <= ((ArrayList) this.i).size()) goto L12;
        this.i.add(new Buffer());
    L12:
        int r2 = this.g;
        this.g = -1;
        this.e = 6;
        return r2;
    L15:
        throw new IOException("Wire recursion limit exceeded");
    L17:
        throw new IllegalStateException("Unexpected call to beginMessage()".toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.lark.wire.h0
    public final i0 i() {
        i0 r0 = this.j;
        if (r0 != null) goto L7;
        i0 r1 = new i0(this);
        this.j = r1;
        return r1;
    L7:
        return r0;
    }

    @Override // com.lark.wire.h0
    public final long l() {
        int r0 = this.e;
        if (r0 != 0) goto L5;
    L9:
        long r1 = 0;
        int r3 = 0;
    L11:
        if (r3 >= 64) goto L18;
        byte r4 = q();
        r1 = r1 | (((long) (r4 & 127)) << r3);
        if ((r4 & 128) == 0) goto L14;
        r3 = r3 + 7;
        goto L11
    L14:
        n(0);
        return r1;
    L18:
        throw new ProtocolException("WireInput encountered a malformed varint");
    L5:
        if (r0 == 2) goto L9;
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.e);
    }

    @Override // com.lark.wire.h0
    public final int nextTag() {
        int r0 = this.e;
        if (r0 != 7) goto L7;
        this.e = 2;
        return this.f;
    L7:
        if (r0 != 6) goto L52;
    L9:
        if (this.b >= this.c) goto L50;
        int r1 = p();
        if (r1 == 0) goto L49;
        int r2 = r1 >> 3;
        this.f = r2;
        int r3 = r1 & 7;
        if (r3 == 0) goto L46;
        if (r3 == 1) goto L44;
        if (r3 == 2) goto L30;
        if (r3 != 3) goto L20;
        r(r2);
        goto L9
    L20:
        if (r3 == 4) goto L28;
        if (r3 != 5) goto L26;
        this.h = FieldEncoding.FIXED32;
        this.e = 5;
        return r2;
    L26:
        throw new ProtocolException("Unexpected field encoding: " + r3);
    L28:
        throw new ProtocolException("Unexpected end group");
    L30:
        this.h = FieldEncoding.LENGTH_DELIMITED;
        this.e = 2;
        int r4 = p();
        if (r4 < 0) goto L43;
        if (this.g != (-1)) goto L41;
        int r5 = this.c;
        this.g = r5;
        int r6 = this.b + r4;
        this.c = r6;
        if (r6 > r5) goto L39;
        return this.f;
    L39:
        throw new EOFException();
    L41:
        throw new IllegalStateException();
    L43:
        throw new ProtocolException("Negative length: " + r4);
    L44:
        this.h = FieldEncoding.FIXED64;
        this.e = 1;
        return r2;
    L46:
        this.h = FieldEncoding.VARINT;
        this.e = 0;
        return r2;
    L49:
        throw new ProtocolException("Unexpected tag 0");
    L50:
        return -1;
    L52:
        throw new IllegalStateException("Unexpected call to nextTag()");
    }

    public final int o() {
        if (this.e != 2) goto L7;
        int r0 = this.c - this.b;
        this.e = 6;
        this.c = this.g;
        this.g = -1;
        return r0;
    L7:
        throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.e);
    }

    public final byte q() {
        int r0 = this.b;
        if (r0 == this.c) goto L7;
        byte[] r1 = this.a;
        this.b = r0 + 1;
        return r1[r0];
    L7:
        throw new EOFException();
    }

    @Override // com.lark.wire.h0
    public final String e() {
        int r0 = o();
        int r2 = this.b;
        int r1 = r0 + r2;
        if (r1 > this.c) goto L7;
        String r3 = StringsKt.decodeToString$default(this.a, r2, r1, false, 4, null);
        this.b = r1;
        return r3;
    L7:
        throw new EOFException();
    }

    @Override // com.lark.wire.h0
    public final ByteString f() {
        int r0 = o();
        int r1 = this.b;
        int r2 = r1 + r0;
        if (r2 > this.c) goto L7;
        ByteString.a r3 = ByteString.Companion;
        byte[] r4 = this.a;
        r3.getClass();
        ByteString r5 = ByteString.a.d(r4, r1, r0);
        this.b = r2;
        return r5;
    L7:
        throw new EOFException();
    }

    public final int p() {
        byte r0 = q();
        if (r0 < 0) goto L5;
        return r0;
    L5:
        int r1 = r0 & 127;
        byte r2 = q();
        if (r2 < 0) goto L9;
        int r3 = r2 << 7;
    L26:
        return r1 | r3;
    L9:
        r1 = r1 | ((r2 & 127) << 7);
        byte r4 = q();
        if (r4 < 0) goto L12;
        r3 = r4 << 14;
        goto L26
    L12:
        r1 = r1 | ((r4 & 127) << 14);
        byte r5 = q();
        if (r5 < 0) goto L15;
        r3 = r5 << 21;
        goto L26
    L15:
        int r6 = r1 | ((r5 & 127) << 21);
        byte r7 = q();
        int r8 = r6 | (r7 << 28);
        if (r7 >= 0) goto L29;
        int r9 = 0;
    L19:
        if (r9 >= 5) goto L25;
        if (q() >= 0) goto L22;
        r9 = r9 + 1;
        goto L19
    L22:
        return r8;
    L25:
        throw new ProtocolException("Malformed VARINT");
    L29:
        return r8;
    }

    @Override // com.lark.wire.h0
    public final ByteString k(int r6) {
        boolean r2 = true;
        if (this.e != 6) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L28;
        int r1 = this.d - 1;
        this.d = r1;
        if (r1 >= 0) goto L10;
    L12:
        r2 = false;
    L13:
        if (r2 == false) goto L26;
        if (this.b == this.c) goto L20;
        if (r1 == 0) goto L20;
        throw new IOException("Expected to end at " + this.c + " but was " + this.b);
    L20:
        this.c = r6;
        Buffer r7 = (Buffer) ListProtector.get(this.i, r1);
        if (r7.size() <= 0) goto L24;
        return r7.readByteString();
    L24:
        return ByteString.EMPTY;
    L26:
        throw new IllegalStateException("No corresponding call to beginMessage()".toString());
    L10:
        if (this.g != (-1)) goto L12;
    L28:
        throw new IllegalStateException("Unexpected call to endMessage()".toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.lark.wire.h0
    public final void m(int r3) {
        FieldEncoding r0 = this.h;
        Intrinsics.checkNotNull(r0);
        j(r3, r0, r0.rawProtoAdapter().b(this));
    }

    public final void n(int r3) {
        if (this.e != r3) goto L5;
        this.e = 6;
        return;
    L5:
        int r4 = this.b;
        int r0 = this.c;
        if (r4 > r0) goto L12;
        if (r4 != r0) goto L9;
        this.c = this.g;
        this.g = -1;
        this.e = 6;
        return;
    L9:
        this.e = 7;
        return;
    L12:
        throw new IOException("Expected to end at " + this.c + " but was " + this.b);
    }

    public final void r(int r5) {
    L3:
        if (this.b >= this.c) goto L44;
        int r0 = p();
        if (r0 == 0) goto L42;
        int r1 = r0 >> 3;
        int r2 = r0 & 7;
        if (r2 != 0) goto L9;
        this.e = 0;
        l();
        goto L3
    L9:
        if (r2 != 1) goto L11;
        this.e = 1;
        g();
        goto L3
    L11:
        if (r2 != 2) goto L13;
        int r3 = this.b + p();
        if (r3 > this.c) goto L38;
        this.b = r3;
        goto L3
    L38:
        throw new EOFException();
    L13:
        if (r2 != 3) goto L15;
        int r4 = this.d + 1;
        this.d = r4;
        if (r4 > 100) goto L30;
        r(r1);     // Catch: Throwable -> L31
        this.d--;
    L31:
        th = move-exception;
        this.d--;
        throw th;
    L30:
        throw new IOException("Wire recursion limit exceeded");     // Catch: Throwable -> L31
    L15:
        if (r2 == 4) goto L21;
        if (r2 != 5) goto L20;
        this.e = 5;
        d();
        goto L3
    L20:
        throw new ProtocolException("Unexpected field encoding: " + r2);
    L21:
        if (r1 != r5) goto L24;
        return;
    L24:
        throw new ProtocolException("Unexpected end group");
    L42:
        throw new ProtocolException("Unexpected tag 0");
    L44:
        throw new EOFException();
    }

    public a(byte[] r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "source");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.e = 2;
        this.f = -1;
        this.g = -1;
        this.i = new ArrayList();
    }

    @Override // com.lark.wire.h0
    public final void j(int r4, FieldEncoding r5, Object r6) {
        Intrinsics.checkNotNullParameter(r5, "fieldEncoding");
        j0 r0 = new j0((BufferedSink) ListProtector.get(this.i, this.d - 1));
        ProtoAdapter<?> r7 = r5.rawProtoAdapter();
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.lark.wire.ProtoAdapter<kotlin.Any>");
        r7.i(r0, r4, r6);
    }
}
