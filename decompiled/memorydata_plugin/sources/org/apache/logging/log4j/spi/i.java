package org.apache.logging.log4j.spi;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.SimpleMessage;

/* JADX INFO: loaded from: classes6.dex */
public class i implements org.apache.logging.log4j.message.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final org.apache.logging.log4j.message.d f17906a;

    public i(org.apache.logging.log4j.message.d r3) {
        this.f17906a = (org.apache.logging.log4j.message.d) ZeusTransformUtils.preCheckCast(Objects.requireNonNull((org.apache.logging.log4j.message.d) ZeusTransformUtils.wrapperContextForParams(r3, org.apache.logging.log4j.message.d.class, "com.obric.memorydata.plugin")), org.apache.logging.log4j.message.d.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(CharSequence r2) {
        return new SimpleMessage((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.logging.log4j.message.d
    public Message newMessage(Object r1) {
        return this.f17906a.newMessage(r1);
    }

    @Override // org.apache.logging.log4j.message.d
    public Message newMessage(String r1) {
        return this.f17906a.newMessage(r1);
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4) {
        return this.f17906a.newMessage(r3, new Object[]{r4});
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5) {
        return this.f17906a.newMessage(r3, new Object[]{r4, r5});
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6) {
        return this.f17906a.newMessage(r3, new Object[]{r4, r5, r6});
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6, Object r7) {
        return this.f17906a.newMessage(r3, new Object[]{r4, r5, r6, r7});
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6, Object r7, Object r8) {
        return this.f17906a.newMessage(r3, new Object[]{r4, r5, r6, r7, r8});
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9) {
        return this.f17906a.newMessage(r3, new Object[]{r4, r5, r6, r7, r8, r9});
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10) {
        return this.f17906a.newMessage(r3, new Object[]{r4, r5, r6, r7, r8, r9, r10});
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11) {
        return this.f17906a.newMessage(r3, new Object[]{r4, r5, r6, r7, r8, r9, r10, r11});
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11, Object r12) {
        return this.f17906a.newMessage(r3, new Object[]{r4, r5, r6, r7, r8, r9, r10, r11, r12});
    }

    @Override // org.apache.logging.log4j.message.e
    public Message newMessage(String r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11, Object r12, Object r13) {
        return this.f17906a.newMessage(r3, new Object[]{r4, r5, r6, r7, r8, r9, r10, r11, r12, r13});
    }

    @Override // org.apache.logging.log4j.message.d
    public Message newMessage(String r1, Object... r2) {
        return this.f17906a.newMessage(r1, r2);
    }
}
