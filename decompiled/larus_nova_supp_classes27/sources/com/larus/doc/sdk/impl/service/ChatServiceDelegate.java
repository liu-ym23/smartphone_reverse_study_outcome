package com.larus.doc.sdk.impl.service;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\f\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001J\b\u0010\r\u001a\u00020\nH\u0016J(\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u000e\u0010\u0017\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\u0018\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u0010\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0011H\u0016J\b\u0010 \u001a\u00020\nH\u0016J\b\u0010!\u001a\u00020\u0011H\u0016J\u001c\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\nH\u0016J\b\u0010(\u001a\u00020\nH\u0016J\b\u0010)\u001a\u00020\nH\u0016J\b\u0010*\u001a\u00020\nH\u0016J\u001c\u0010+\u001a\u00020\n2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0-H\u0016J\u0010\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u0011H\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/larus/doc/sdk/impl/service/ChatServiceDelegate;", "Lcom/larus/doc/sdk/api/IChatService;", "<init>", "()V", "getRealImpl", "id", "", "chatServices", "Ljava/util/concurrent/CopyOnWriteArrayList;", "addChatService", "", "chatService", "removeChatService", "selectCurrentSentenceOrParagraph", "setChatInputVisible", "from", "visible", "", "aiEditMode", "normalMode", "isChatInputVisible", "getChatInputHeight", "", "getAppIconUrl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isEnableVoiceInput", "setEnableVoiceInput", "enable", "getVoiceInputStatus", "Lkotlinx/coroutines/flow/StateFlow;", "onDocStateChanged", "isEmpty", "setToAiEdit", "consumeToAiEdit", "notifyInitChatInput", "container", "Landroid/view/ViewGroup;", "frgManager", "Landroidx/fragment/app/FragmentManager;", "onDocDeleted", "onDocNeedUpdate", "requestChatInputFocus", "onLoadFinishEventReported", "getLatestMessageId", "callback", "Lkotlin/Function1;", "setChatInputVisibility", "isHidden", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatServiceDelegate implements n39.c {
    private CopyOnWriteArrayList<n39.c> chatServices;

    public Function0<String> getIdGetter() {
        return null;
    }

    @Override // n39.c
    public boolean consumeToAiEdit() {
        n39.c r0 = (n39.c) CollectionsKt.lastOrNull(this.chatServices);
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.consumeToAiEdit();
    }

    @Override // n39.c
    public int getChatInputHeight() {
        n39.c r0 = (n39.c) CollectionsKt.lastOrNull(this.chatServices);
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getChatInputHeight();
    }

    @Override // n39.c
    public i1<Boolean> getVoiceInputStatus() {
        n39.c r0 = (n39.c) CollectionsKt.lastOrNull(this.chatServices);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getVoiceInputStatus();
    }

    @Override // n39.c
    public boolean isChatInputVisible() {
        n39.c r0 = (n39.c) CollectionsKt.lastOrNull(this.chatServices);
        if (r0 != null) goto L5;
        return true;
    L5:
        return r0.isChatInputVisible();
    }

    @Override // n39.c
    public boolean isEnableVoiceInput() {
        n39.c r0 = (n39.c) CollectionsKt.lastOrNull(this.chatServices);
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.isEnableVoiceInput();
    }

    @Override // n39.c
    public void onDocDeleted() {
        Iterator<T> r0 = this.chatServices.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((n39.c) r0.next()).onDocDeleted();
        goto L4
    }

    @Override // n39.c
    public void onDocNeedUpdate() {
        Iterator<T> r0 = this.chatServices.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((n39.c) r0.next()).onDocNeedUpdate();
        goto L4
    }

    @Override // n39.c
    public void onLoadFinishEventReported() {
        Iterator<T> r0 = this.chatServices.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((n39.c) r0.next()).onLoadFinishEventReported();
        goto L4
    }

    @Override // n39.c
    public void requestChatInputFocus() {
        Iterator<T> r0 = this.chatServices.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((n39.c) r0.next()).requestChatInputFocus();
        goto L4
    }

    @Override // n39.c
    public void selectCurrentSentenceOrParagraph() {
        Iterator<T> r0 = this.chatServices.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((n39.c) r0.next()).selectCurrentSentenceOrParagraph();
        goto L4
    }

    @Override // n39.c
    public void setToAiEdit() {
        Iterator<T> r0 = this.chatServices.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((n39.c) r0.next()).setToAiEdit();
        goto L4
    }

    public ChatServiceDelegate() {
        this.chatServices = new CopyOnWriteArrayList();
    }

    public final void addChatService(n39.c r2) {
        if (r2 == null) goto L5;
        this.chatServices.add(r2);
        return;
    }

    @Override // n39.c
    public Object getAppIconUrl(Continuation<? super String> r2) {
        n39.c r0 = (n39.c) CollectionsKt.lastOrNull(this.chatServices);
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0.getAppIconUrl(r2);
    }

    @Override // n39.c
    public void getLatestMessageId(Function1<? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        n39.c r0 = (n39.c) CollectionsKt.lastOrNull(this.chatServices);
        if (r0 == null) goto L5;
        r0.getLatestMessageId(r2);
        return;
    L5:
        r2.invoke("");
    }

    /* JADX INFO: renamed from: getRealImpl, reason: collision with other method in class */
    public n39.c m47getRealImpl(String r5) {
        Intrinsics.checkNotNullParameter(r5, "id");
        CopyOnWriteArrayList<n39.c> r0 = this.chatServices;
        ListIterator<n39.c> r1 = r0.listIterator(r0.size());
    L3:
        Object r2 = null;
        if (r1.hasPrevious() == false) goto L12;
        n39.c r3 = r1.previous();
        Function0 r4 = r3.getIdGetter();
        if (r4 == null) goto L9;
        r2 = (String) r4.invoke();
    L9:
        if (Intrinsics.areEqual(r2, r5) == false) goto L3;
        r2 = r3;
    L12:
        return (n39.c) r2;
    }

    @Override // n39.c
    public void onDocStateChanged(boolean r3) {
        Iterator<T> r0 = this.chatServices.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((n39.c) r0.next()).onDocStateChanged(r3);
        goto L4
    }

    public final void removeChatService(n39.c r2) {
        if (r2 == null) goto L5;
        this.chatServices.remove(r2);
        return;
    }

    @Override // n39.c
    public void setChatInputVisibility(boolean r3) {
        Iterator<T> r0 = this.chatServices.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((n39.c) r0.next()).setChatInputVisibility(r3);
        goto L4
    }

    public /* bridge */ /* synthetic */ Object getRealImpl(String r1) {
        return m47getRealImpl(r1);
    }

    @Override // n39.c
    public void notifyInitChatInput(ViewGroup r3, FragmentManager r4) {
        Iterator<T> r0 = this.chatServices.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((n39.c) r0.next()).notifyInitChatInput(r3, r4);
        goto L4
    }

    @Override // n39.c
    public void setEnableVoiceInput(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "from");
        n39.c r0 = (n39.c) CollectionsKt.lastOrNull(this.chatServices);
        if (r0 == null) goto L6;
        r0.setEnableVoiceInput(r2, r3);
        return;
    }

    @Override // n39.c
    public void setChatInputVisible(String r3, boolean r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "from");
        Iterator<T> r0 = this.chatServices.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((n39.c) r0.next()).setChatInputVisible(r3, r4, r5, r6);
        goto L4
    }
}
