package com.ss.android.lark.image.entity;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.bytedance.lark.pb.basic.v1.ImageSet;
import com.bytedance.lark.pb.basic.v1.Trace;
import com.larksuite.framework.callback.Entity.ErrorResult;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class EncryptImage implements Key, Serializable {
    private static final int DRAFT_RESOURCE_SOURCE_UNKNOWN = 0;
    private volatile transient byte[] cacheKeyBytes;
    private String contextId;
    private final long createTime;
    private ByteString crypto;
    private long decodeStartTime;
    private long decryptTime;
    private int draftResourceSource;
    private final String encryptKey;
    private transient ErrorResult errorResult;
    private String formatHeader;
    private String fsUnit;
    private String imageType;
    private boolean needCollectTrace;
    private String resourceHash;
    private long resourceSize;
    private boolean storeToPrivatePath;
    private transient Trace trace;
    private long waitTime;

    public int hashCode() {
        return Objects.hash(new Object[]{this.encryptKey, Boolean.valueOf(this.storeToPrivatePath)});
    }

    private byte[] getCacheKeyBytes() {
        if (this.cacheKeyBytes != null) goto L6;
        this.cacheKeyBytes = this.encryptKey.getBytes(Key.CHARSET);
    L6:
        return this.cacheKeyBytes;
    }

    public Map<String, Object> getLatencyDetail() {
        HashMap r0 = new HashMap();
        Trace r1 = this.trace;
        if (r1 == null) goto L17;
        Iterator r2 = r1.spans.iterator();
    L6:
        if (r2.hasNext() == false) goto L17;
        Trace.Span r3 = (Trace.Span) r2.next();
        if (TextUtils.isEmpty(r3.name) == true) goto L6;
        Long r4 = r3.duration_millis;
        if (r4 == null) goto L6;
        r0.put(r3.name, r4);
        Map r5 = r3.attributes;
        if (r5 == null) goto L6;
        if (r5.size() <= 0) goto L6;
        r0.putAll(r3.attributes);
    L17:
        return r0;
    }

    public String toString() {
        return "EncryptImage#key is:" + this.encryptKey;
    }

    public String getContextId() {
        return this.contextId;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public ByteString getCrypto() {
        return this.crypto;
    }

    public long getDecodeStartTime() {
        return this.decodeStartTime;
    }

    public long getDecryptTime() {
        return this.decryptTime;
    }

    public int getDraftResourceSource() {
        return this.draftResourceSource;
    }

    public String getEncryptKey() {
        return this.encryptKey;
    }

    public ErrorResult getErrorResult() {
        return this.errorResult;
    }

    public String getFormatHeader() {
        return this.formatHeader;
    }

    public String getFsUnit() {
        return this.fsUnit;
    }

    public String getImageType() {
        return this.imageType;
    }

    public String getResourceHash() {
        return this.resourceHash;
    }

    public long getResourceSize() {
        return this.resourceSize;
    }

    public Trace getTrace() {
        return this.trace;
    }

    public long getWaitTime() {
        return this.waitTime;
    }

    public boolean isNeedCollectTrace() {
        return this.needCollectTrace;
    }

    public boolean storeToPrivatePath() {
        return this.storeToPrivatePath;
    }

    public EncryptImage(String r3) {
        this.needCollectTrace = true;
        this.decryptTime = -1;
        this.draftResourceSource = 0;
        this.encryptKey = r3;
        this.createTime = System.currentTimeMillis();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof EncryptImage) == true) goto L8;
        return false;
    L8:
        EncryptImage r6 = (EncryptImage) r5;
        if (this.storeToPrivatePath == r6.storeToPrivatePath) goto L11;
    L13:
        return false;
    L11:
        if (this.encryptKey.equals(r6.encryptKey) == false) goto L13;
        return true;
    }

    public void setContextId(String r1) {
        this.contextId = r1;
    }

    public void setCrypto(ByteString r1) {
        this.crypto = r1;
    }

    public void setDecodeStartTime(long r1) {
        this.decodeStartTime = r1;
    }

    public void setDecryptTime(long r1) {
        this.decryptTime = r1;
    }

    public void setDraftResourceSource(int r1) {
        this.draftResourceSource = r1;
    }

    public void setErrorResult(ErrorResult r1) {
        this.errorResult = r1;
    }

    public void setFormatHeader(String r1) {
        this.formatHeader = r1;
    }

    public void setFsUnit(String r1) {
        this.fsUnit = r1;
    }

    public void setImageType(String r1) {
        this.imageType = r1;
    }

    public void setNeedCollectTrace(boolean r1) {
        this.needCollectTrace = r1;
    }

    public void setResourceHash(String r1) {
        this.resourceHash = r1;
    }

    public void setResourceSize(long r1) {
        this.resourceSize = r1;
    }

    public void setStoreToPrivatePath(boolean r1) {
        this.storeToPrivatePath = r1;
    }

    public void setTrace(Trace r1) {
        this.trace = r1;
    }

    public void setWaitTime(long r1) {
        this.waitTime = r1;
    }

    public void updateDiskCacheKey(MessageDigest r2) {
        r2.update(getCacheKeyBytes());
    }

    public EncryptImage(Image r3) {
        this(r3.getKey(), r3.getFsUnit(), r3.getCrypto());
    }

    public EncryptImage(String r1, ImageSet r2) {
        this(r1);
        if (r2 == null) goto L23;
        com.bytedance.lark.pb.basic.v1.Image r3 = r2.origin;
        if (r3 == null) goto L7;
        this.fsUnit = r3.fs_unit;
        this.crypto = r3.crypto;
        return;
    L7:
        com.bytedance.lark.pb.basic.v1.Image r4 = r2.middle_webp;
        if (r4 == null) goto L11;
        this.fsUnit = r4.fs_unit;
        this.crypto = r4.crypto;
        return;
    L11:
        com.bytedance.lark.pb.basic.v1.Image r5 = r2.middle;
        if (r5 == null) goto L15;
        this.fsUnit = r5.fs_unit;
        this.crypto = r5.crypto;
        return;
    L15:
        com.bytedance.lark.pb.basic.v1.Image r6 = r2.thumbnail_webp;
        if (r6 == null) goto L19;
        this.fsUnit = r6.fs_unit;
        this.crypto = r6.crypto;
        return;
    L19:
        com.bytedance.lark.pb.basic.v1.Image r7 = r2.thumbnail;
        if (r7 == null) goto L25;
        this.fsUnit = r7.fs_unit;
        this.crypto = r7.crypto;
        return;
    L25:
        return;
    }

    public EncryptImage(String r3, String r4, ByteString r5) {
        this.needCollectTrace = true;
        this.decryptTime = -1;
        this.draftResourceSource = 0;
        this.encryptKey = r3;
        this.fsUnit = r4;
        this.crypto = r5;
        this.createTime = System.currentTimeMillis();
    }
}
