package com.bytedance.retrofit2.mime;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class FormUrlEncodedTypedOutput extends AbsTypedOutput {
    private static AtomicReference<IFormBodyModifyHook> sFormModifyHook;
    ByteArrayOutputStream content;
    private final boolean enableRecordFields;
    private Map<String, List<String>> fields;
    private IFormBodyModifyHook mFormModifyHook;

    public interface IFormBodyModifyHook {
        IFormBodyModifyHook copy();

        Map<String, List<String>> getAllNewFormFields(Request r1);
    }

    static {
        sFormModifyHook = new AtomicReference();
    }

    public FormUrlEncodedTypedOutput() {
        this.content = new ByteArrayOutputStream();
        this.fields = new HashMap();
        this.enableRecordFields = false;
        IFormBodyModifyHook r0 = (IFormBodyModifyHook) ZeusTransformUtils.preCheckCast(sFormModifyHook.get(), IFormBodyModifyHook.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        IFormBodyModifyHook r1 = r0.copy();
    L6:
        this.mFormModifyHook = r1;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public FormUrlEncodedTypedOutput(boolean r3) {
        this.content = new ByteArrayOutputStream();
        this.fields = new HashMap();
        this.enableRecordFields = r3;
        IFormBodyModifyHook r4 = (IFormBodyModifyHook) ZeusTransformUtils.preCheckCast(sFormModifyHook.get(), IFormBodyModifyHook.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L5;
        IFormBodyModifyHook r5 = r4.copy();
    L6:
        this.mFormModifyHook = r5;
        return;
    L5:
        r5 = null;
        goto L6
    }

    public static void setFormBodyModifyHook(IFormBodyModifyHook r2) {
        IFormBodyModifyHook r3 = (IFormBodyModifyHook) ZeusTransformUtils.wrapperContextForParams(r2, IFormBodyModifyHook.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        sFormModifyHook.set(null);
        return;
    L6:
        sFormModifyHook.set(r3.copy());
    }

    private void writeFieldToContentStream(String r3, boolean r4, String r5, boolean r6) {
        if (this.content.size() <= 0) goto L6;
        this.content.write(38);
    L6:
        if (r4 == false) goto L8;
        r3 = URLEncoder.encode(r3, RpcUtils.CHARSET_UTF8);
    L8:
        if (r6 == false) goto L10;
        r5 = URLEncoder.encode(r5, RpcUtils.CHARSET_UTF8);
    L10:
        this.content.write(r3.getBytes(RpcUtils.CHARSET_UTF8));
        this.content.write(61);
        this.content.write(r5.getBytes(RpcUtils.CHARSET_UTF8));
    }

    public void addField(String r2, String r3) {
        addField(r2, true, r3, true);
    }

    public void addField(String r4, boolean r5, String r6, boolean r7) {
        Objects.requireNonNull(r4, ActivityLifecycle.NAME);
        Objects.requireNonNull(r6, EventBody.KEY_VALUE);
        if (this.enableRecordFields == true) goto L7;
        if (this.mFormModifyHook != null) goto L7;
    L11:
        if (this.mFormModifyHook == null) goto L18;
        return;
    L18:
        writeFieldToContentStream(r4, r5, r6, r7);     // Catch: IOException -> L14
        return;
    L14:
        e = move-exception;
        throw new RuntimeException(e);
    L7:
        if (this.fields.containsKey(r4) == false) goto L9;
        ((List) ZeusTransformUtils.preCheckCast(this.fields.get(r4), List.class, "com.obric.memorydata.plugin")).add(r6);
        goto L11
    L9:
        ArrayList r0 = new ArrayList();
        r0.add(r6);
        this.fields.put(r4, r0);
        goto L11
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
    public TTRequestCompressManager.CompressData compressRequestBody(String r3, String r4, boolean r5) {
        byte[] r0 = this.content.toByteArray();
        if (r0 != null) goto L6;
        return null;
    L6:
        TTRequestCompressManager.CompressData r6 = TTRequestCompressManager.compressBody(r0, r0.length, r3, r4, r5);
        if (r6 != null) goto L9;
    L12:
        return r6;
    L9:
        if (r6.data == null) goto L12;
        this.mOriginBodySize = r0.length;
        ByteArrayOutputStream r7 = new ByteArrayOutputStream(r6.data.length);
        this.content = r7;
        r7.write(r6.data, 0, r6.data.length);
        this.mType = r6.contentEncoding;
        goto L12
    }

    public Map<String, List<String>> fields() {
        return this.fields;
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public String fileName() {
        return null;
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
    public byte[] getOriginBody() {
        return TTRequestCompressManager.decompressDataByType(this.content.toByteArray(), this.mType, this.mOriginBodySize);
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
    public boolean interceptRequestBody() {
        byte[] r0 = this.content.toByteArray();
        if (r0 != null) goto L5;
    L12:
        return false;
    L5:
        if (r0.length > 102400) goto L12;
        byte[] r1 = EncryptorUtil.a(r0, r0.length);
        if (r1 != null) goto L10;
        return false;
    L10:
        ByteArrayOutputStream r2 = new ByteArrayOutputStream(r1.length);
        this.content = r2;
        r2.write(r1, 0, r1.length);
        this.mIsBodyEncrypted = true;
        return true;
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public long length() {
        return this.content.size();
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public String md5Stub() {
        this.mBodyMd5Stub = DigestUtil.md5Hex(this.content.toByteArray());
        return this.mBodyMd5Stub;
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public String mimeType() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    public void useFormBodyModifyHookAndConstructStream(Request r7) {
        IFormBodyModifyHook r0 = this.mFormModifyHook;
        if (r0 != null) goto L5;
        return;
    L5:
        Map<String, List<String>> r8 = r0.getAllNewFormFields(r7);
        this.fields = r8;
        if (r8 != null) goto L8;
        return;
    L8:
        if (r8.isEmpty() == true) goto L29;
        Iterator<Map.Entry<String, List<String>>> r9 = this.fields.entrySet().iterator();
    L12:
        if (r9.hasNext() == false) goto L30;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Iterator r2 = ((List) ZeusTransformUtils.preCheckCast(r1.getValue(), List.class, "com.obric.memorydata.plugin")).iterator();
    L15:
        if (r2.hasNext() == false) goto L12;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        writeFieldToContentStream((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin"), true, r3, true);     // Catch: Exception -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L30:
        return;
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public void writeTo(OutputStream r1) {
        r1.write(this.content.toByteArray());
    }
}
