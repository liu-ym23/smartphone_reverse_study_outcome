package kotlin.text;

import java.util.List;
import java.util.regex.Matcher;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes3.dex */
final class MatcherMatchResult implements MatchResult {
    private List<String> groupValues_;
    private final MatchGroupCollection groups;
    private final CharSequence input;
    private final Matcher matcher;

    public MatcherMatchResult(Matcher r10, CharSequence r11) {
        Intrinsics.checkNotNullParameter(r10, "matcher");
        Intrinsics.checkNotNullParameter(r11, "input");
        this.matcher = r10;
        this.input = r11;
        this.groups = new MatcherMatchResult$groups$1(this);
    }

    public static final /* synthetic */ java.util.regex.MatchResult access$getMatchResult(MatcherMatchResult r10) {
        return r10.getMatchResult();
    }

    private final java.util.regex.MatchResult getMatchResult() {
        return this.matcher;
    }

    @Override // kotlin.text.MatchResult
    public MatchResult.Destructured getDestructured() {
        return MatchResult.DefaultImpls.getDestructured(this);
    }

    @Override // kotlin.text.MatchResult
    public List<String> getGroupValues() {
        if (this.groupValues_ != null) goto L5;
        this.groupValues_ = new MatcherMatchResult$groupValues$1(this);
    L5:
        List<String> r10 = this.groupValues_;
        Intrinsics.checkNotNull(r10);
        return r10;
    }

    @Override // kotlin.text.MatchResult
    public MatchGroupCollection getGroups() {
        return this.groups;
    }

    @Override // kotlin.text.MatchResult
    public IntRange getRange() {
        return RegexKt.access$range(getMatchResult());
    }

    @Override // kotlin.text.MatchResult
    public String getValue() {
        String r10 = getMatchResult().group();
        Intrinsics.checkNotNullExpressionValue(r10, "matchResult.group()");
        return r10;
    }

    @Override // kotlin.text.MatchResult
    public MatchResult next() {
        int r10 = getMatchResult().end();
        if (getMatchResult().end() != getMatchResult().start()) goto L5;
        int r11 = 1;
    L6:
        int r12 = r10 + r11;
        if (r12 > this.input.length()) goto L9;
        Matcher r13 = this.matcher.pattern().matcher(this.input);
        Intrinsics.checkNotNullExpressionValue(r13, "matcher.pattern().matcher(input)");
        return RegexKt.access$findNext(r13, r12, this.input);
    L9:
        return null;
    L5:
        r11 = 0;
        goto L6
    }
}
