package com.ss.android.lark.chat.entity.image;

import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.image.entity.BaseImageSet;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ImageSet extends BaseImageSet {
    private static final long serialVersionUID = 3501109319906571184L;
    private boolean hasPreviewPermission;
    private ImageAuthAction imageAuthAction;
    protected ByteString inlinePreview;
    protected Image intact;
    private boolean isFromMe;
    private boolean isOriginSource;
    protected boolean isTranslated;
    protected MessageIdentity messageIdentity;
    private long originSize;
    private int receiveAuthorizationStateValue;
    private ResourceCleanScene resourceCleanScene;
    boolean resourceIsCleaned;
    private String senderTenantId;
    private ValidateIMFileResult validateIMFileResult;

    public ImageSet() {
        this.isOriginSource = false;
        this.originSize = 0;
        this.hasPreviewPermission = true;
        this.receiveAuthorizationStateValue = 4;
        this.resourceIsCleaned = false;
        this.resourceCleanScene = null;
    }

    public ImageAuthAction getImageAuthAction() {
        return this.imageAuthAction;
    }

    public ByteString getInlinePreview() {
        return this.inlinePreview;
    }

    public Image getIntact() {
        return this.intact;
    }

    public MessageIdentity getMessageIdentity() {
        return this.messageIdentity;
    }

    public long getOriginSize() {
        return this.originSize;
    }

    public int getReceiveAuthorizationStateValue() {
        return this.receiveAuthorizationStateValue;
    }

    public ResourceCleanScene getResourceCleanScene() {
        return this.resourceCleanScene;
    }

    public String getSenderTenantId() {
        return this.senderTenantId;
    }

    public ValidateIMFileResult getValidateIMFileResult() {
        return this.validateIMFileResult;
    }

    public boolean isFromMe() {
        return this.isFromMe;
    }

    public boolean isHasPreviewPermission() {
        return this.hasPreviewPermission;
    }

    public boolean isOriginSource() {
        return this.isOriginSource;
    }

    public boolean isTranslated() {
        return this.isTranslated;
    }

    public void setFromMe(boolean r1) {
        this.isFromMe = r1;
    }

    public void setHasPreviewPermission(boolean r1) {
        this.hasPreviewPermission = r1;
    }

    public void setImageAuthAction(ImageAuthAction r1) {
        this.imageAuthAction = r1;
    }

    public void setInlinePreview(ByteString r1) {
        this.inlinePreview = r1;
    }

    public void setIntact(Image r1) {
        this.intact = r1;
    }

    public void setMessageIdentity(MessageIdentity r1) {
        this.messageIdentity = r1;
    }

    public void setOriginSize(long r1) {
        this.originSize = r1;
    }

    public void setOriginSource(boolean r1) {
        this.isOriginSource = r1;
    }

    public void setReceiveAuthorizationStateValue(int r1) {
        this.receiveAuthorizationStateValue = r1;
    }

    public void setResourceCleanScene(ResourceCleanScene r1) {
        this.resourceCleanScene = r1;
    }

    public void setResourceIsCleaned(boolean r1) {
        this.resourceIsCleaned = r1;
    }

    public void setSenderTenantId(String r1) {
        this.senderTenantId = r1;
    }

    public void setTranslated(boolean r1) {
        this.isTranslated = r1;
    }

    public void setValidateIMFileResult(ValidateIMFileResult r1) {
        this.validateIMFileResult = r1;
    }

    public ImageSet(String r1, Image r2, Image r3) {
        super(r1, r2, r3);
        this.isOriginSource = false;
        this.originSize = 0;
        this.hasPreviewPermission = true;
        this.receiveAuthorizationStateValue = 4;
        this.resourceIsCleaned = false;
        this.resourceCleanScene = null;
    }

    public ImageSet(String r1, Image r2, Image r3, Image r4, ByteString r5, MessageIdentity r6) {
        super(r1, r2, r3);
        this.isOriginSource = false;
        this.originSize = 0;
        this.hasPreviewPermission = true;
        this.receiveAuthorizationStateValue = 4;
        this.resourceIsCleaned = false;
        this.resourceCleanScene = null;
        ((BaseImageSet) this).middle = r4;
        this.inlinePreview = r5;
        this.messageIdentity = r6;
    }
}
