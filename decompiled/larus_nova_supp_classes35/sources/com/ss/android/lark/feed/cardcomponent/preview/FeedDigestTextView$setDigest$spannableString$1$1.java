package com.ss.android.lark.feed.cardcomponent.preview;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.feed.app.entity.DigestElement;
import com.ss.android.lark.utils.ViewUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/feed/cardcomponent/preview/FeedDigestTextView$setDigest$spannableString$1$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", BuildConfig.FLAVOR, "onSuccess", BuildConfig.FLAVOR, "aBoolean", "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "feed-card-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedDigestTextView$setDigest$spannableString$1$1 implements IGetDataCallback<Boolean> {
    final /* synthetic */ int $emojiSizeDp;
    final /* synthetic */ FeedDigestTextView $this_run;

    public static final class a implements Runnable {
        public final /* synthetic */ FeedDigestTextView a;
        public final /* synthetic */ int b;

        public a(FeedDigestTextView r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [android.widget.TextView, com.ss.android.lark.feed.cardcomponent.preview.FeedDigestTextView] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.lang.Runnable
        public final void run() {
            List<? extends DigestElement> r0 = this.a.a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            ?? r1 = this.a;     // Catch: Throwable -> L6
            r1.setText(r1.x(r0, null, this.b));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public void onError(ErrorResult r2) {
        Intrinsics.checkNotNullParameter(r2, "err");
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public void onSuccess(boolean r3) {
        ViewUtils.runOnUiThread(new a(this.$this_run, this.$emojiSizeDp));
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess(((Boolean) r1).booleanValue());
    }

    public FeedDigestTextView$setDigest$spannableString$1$1(FeedDigestTextView r1, int r2) {
        this.$this_run = r1;
        this.$emojiSizeDp = r2;
    }
}
