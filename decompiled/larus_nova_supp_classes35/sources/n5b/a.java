package n5b;

import android.text.TextUtils;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageFoldDetail;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.Pin;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.ss.android.lark.chat.entity.translate.TranslateInfo;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.ding.entity.DingStatus;
import f5b.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements b, y28.b<a> {
    public ChatChatter a;
    public ThreadTopic b;
    public Message c;
    public List<ReactionInfo> d;
    public List<MessageInfo> e;
    public List<MessageInfo> f;
    public Pin g;
    public TranslateInfo h;
    public ChatChatter i;
    public final boolean j;
    public Boolean k;
    public Chat l;
    public boolean m;
    public DingStatus n;
    public ChatChatter o;

    @Override // f5b.b
    public final MessageFoldDetail getMessageFoldDetail() {
        return null;
    }

    @Override // f5b.b
    public final ArrayList<String> getMsgIdPathList() {
        return null;
    }

    @Override // f5b.b
    public final b getParent() {
        return null;
    }

    @Override // f5b.b
    public final boolean isIntermediateMessage() {
        return false;
    }

    @Override // f5b.b
    public final void setMessageFoldDetail(MessageFoldDetail r1) {
    }

    @Override // f5b.b
    public final boolean canShow() {
        return this.c.canShow();
    }

    @Override // f5b.b
    public final List<String> getAuthFileKeys() {
        return this.c.getAuthFileKeys();
    }

    @Override // f5b.b
    public final String getId() {
        return this.b.getId();
    }

    @Override // f5b.b
    public final long getUpdateTime() {
        return this.b.getUpdateTime();
    }

    @Override // f5b.b
    public final String getcId() {
        return this.c.getcId();
    }

    @Override // f5b.b
    public final boolean isNoTraceDelete() {
        if (this.b.isNoTraceDelete() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.c.isNoTraceDelete() == true) goto L8;
        return false;
    }

    @Override // f5b.b
    public final boolean isPreMessage() {
        return this.c.isPreMessage();
    }

    @Override // f5b.b, p5b.a
    public final boolean isShowMessageOriginContent() {
        String r0 = this.c.getTranslateLanguage();
        TranslateInfo r1 = this.h;
        if (TextUtils.isEmpty(r0) == true) goto L11;
        if (r1 == null) goto L11;
        if (r0.equals(r1.getLanguage()) == false) goto L11;
        if (this.c.getStatus() == Message.Status.DELETED) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // f5b.b
    public final boolean isTranslating() {
        Boolean r0 = this.k;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.booleanValue() == false) goto L7;
        return true;
    }

    @Override // f5b.b
    public final boolean isTranslatingInited() {
        if (this.k == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final String toString() {
        return "id:" + this.b.getId() + ", position:" + this.b.getPosition() + ", badgeCount:" + this.b.getBadgeCount() + ", messageType:" + this.c.getType();
    }

    public a() {
        this.j = true;
        this.k = null;
    }

    @Override // f5b.b
    public final b clone() {
        return (b) super.clone();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // f5b.b
    public final Message getMessage() {
        return this.c;
    }

    @Override // f5b.b
    public final ChatChatter getMessageSender() {
        return this.a;
    }

    @Override // f5b.b
    public final Pin getPin() {
        return this.g;
    }

    @Override // f5b.b
    public final List<ReactionInfo> getReactionInfoList() {
        return this.d;
    }

    @Override // f5b.b
    public final TranslateInfo getTranslateInfo() {
        return this.h;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m1246clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // p5b.c, f5b.b
    public final p5b.b getMessage() {
        return this.c;
    }

    @Override // f5b.b, p5b.a
    public final Content getTranslateContent(boolean r1) {
        if (r1 == false) goto L6;
        return this.c.getContent();
    L6:
        return this.h.getTranslateContent();
    }

    public final boolean isContentSame(y28.b r3) {
        a r4 = (a) r3;
        if (y28.a.c(this.a, r4.a) == true) goto L6;
        return false;
    L6:
        if (y28.a.c(this.c, r4.c) == true) goto L9;
        return false;
    L9:
        if (y28.a.c(this.b, r4.b) == true) goto L12;
        return false;
    L12:
        if (y28.a.b(this.e, r4.e) == true) goto L15;
        return false;
    L15:
        if (y28.a.b(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (y28.a.c(this.i, r4.i) == true) goto L21;
        return false;
    L21:
        if (y28.a.c(this.n, r4.n) == true) goto L24;
        return false;
    L24:
        if (y28.a.c(this.o, r4.o) == false) goto L49;
        TranslateInfo r0 = this.h;
        if (r0 == null) goto L33;
        TranslateInfo r1 = r4.h;
        if (r1 == null) goto L33;
        if (r0.equals(r1) == true) goto L33;
        return false;
    L33:
        if (this.j == r4.j) goto L35;
        return false;
    L35:
        if (this.k.equals(r4.k) == true) goto L38;
        return false;
    L38:
        throw null;
    L49:
        return false;
    }

    public final boolean isItemSame(y28.b r2) {
        return Objects.equals(this.b.getId(), ((a) r2).b.getId());
    }

    @Override // f5b.b
    public final void setDingStatus(DingStatus r1) {
        this.n = r1;
    }

    @Override // f5b.b
    public final void setForceUpdate(boolean r1) {
        this.m = r1;
    }

    @Override // f5b.b
    public final void setIsTranslating(boolean r1) {
        this.k = Boolean.valueOf(r1);
    }

    @Override // f5b.b
    public final void setMessage(Message r1) {
        this.c = r1;
    }

    @Override // f5b.b
    public final void setMessageSender(ChatChatter r1) {
        this.a = r1;
    }

    @Override // f5b.b
    public final void setTranslateInfo(TranslateInfo r1) {
        this.h = r1;
    }

    public a(ChatChatter r2, ThreadTopic r3, Message r4) {
        this.j = true;
        this.k = null;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
