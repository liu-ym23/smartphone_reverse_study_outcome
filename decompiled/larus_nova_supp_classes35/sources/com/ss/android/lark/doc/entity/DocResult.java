package com.ss.android.lark.doc.entity;

import android.text.TextUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import y28.a;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class DocResult implements Serializable, b<DocResult> {
    private Doc doc;
    private DocCard docCard;
    private List<String> messageIds;

    public String getDocCardId() {
        DocCard r0 = this.docCard;
        if (r0 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        return r0.getDocId();
    }

    public List<String> getMessageIds() {
        List<String> r0 = this.messageIds;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new ArrayList();
    }

    public int hashCode() {
        Doc r0 = this.doc;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        DocCard r4 = this.docCard;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public DocResult() {
    }

    public Doc getDoc() {
        return this.doc;
    }

    public DocCard getDocCard() {
        return this.docCard;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L25:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L25;
        DocResult r6 = (DocResult) r5;
        Doc r2 = this.doc;
        if (r2 == null) goto L16;
        if (r2.equals(r6.doc) == false) goto L17;
    L18:
        DocCard r3 = this.docCard;
        DocCard r7 = r6.docCard;
        if (r3 != null) goto L26;
        if (r7 == null) goto L27;
        return false;
    L27:
        return true;
    L26:
        return r3.equals(r7);
    L17:
        return false;
    L16:
        if (r6.doc == null) goto L18;
        goto L17
    }

    public boolean isContentSame(DocResult r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (a.c(this.doc, r4.getDoc()) == true) goto L9;
        return false;
    L9:
        if (a.c(this.docCard, r4.getDocCard()) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public boolean isItemSame(DocResult r5) {
        if (this.docCard != null) goto L8;
        if (r5 != null) goto L6;
    L7:
        return true;
    L6:
        if (r5.getDocCard() == null) goto L7;
    L8:
        String r0 = this.docCard.getMessageId();
        String r2 = BuildConfig.FLAVOR;
        if (r5 == null) goto L16;
        if (r5.getDocCard() == null) goto L16;
        r2 = r5.getDocCard().getMessageId();
    L16:
        if (TextUtils.equals(r0, r2) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public void setDoc(Doc r1) {
        this.doc = r1;
    }

    public void setDocCard(DocCard r1) {
        this.docCard = r1;
    }

    public void setMessageIds(List<String> r1) {
        this.messageIds = r1;
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((DocResult) r1);
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((DocResult) r1);
    }

    public DocResult(Doc r1, DocCard r2) {
        this.doc = r1;
        this.docCard = r2;
    }

    public DocResult(Doc r1, DocCard r2, List<String> r3) {
        this.doc = r1;
        this.docCard = r2;
        this.messageIds = r3;
    }
}
