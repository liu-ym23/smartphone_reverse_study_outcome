package org.commonmark.parser;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.commonmark.Extension;
import org.commonmark.internal.DocumentParser;
import org.commonmark.internal.InlineParserContextImpl;
import org.commonmark.node.Block;
import org.commonmark.node.Node;
import org.commonmark.parser.block.BlockParserFactory;
import org.commonmark.parser.delimiter.DelimiterProcessor;

/* JADX INFO: loaded from: classes7.dex */
public class Parser {
    private final List<BlockParserFactory> blockParserFactories;
    private final List<DelimiterProcessor> delimiterProcessors;
    private final InlineParserFactory inlineParserFactory;
    private final LinkReferenceChecker linkReferenceChecker;
    private final List<PostProcessor> postProcessors;

    /* JADX INFO: renamed from: org.commonmark.parser.Parser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private final List<BlockParserFactory> blockParserFactories;
        private final List<DelimiterProcessor> delimiterProcessors;
        private Set<Class<? extends Block>> enabledBlockTypes;
        private InlineParserFactory inlineParserFactory;
        private LinkReferenceChecker linkReferenceChecker;
        private final List<PostProcessor> postProcessors;

        public Builder() {
            this.blockParserFactories = new ArrayList();
            this.delimiterProcessors = new ArrayList();
            this.postProcessors = new ArrayList();
            this.enabledBlockTypes = DocumentParser.getDefaultBlockParserTypes();
            this.linkReferenceChecker = null;
        }

        static /* synthetic */ List access$000(Builder r0) {
            return r0.blockParserFactories;
        }

        static /* synthetic */ Set access$100(Builder r0) {
            return r0.enabledBlockTypes;
        }

        static /* synthetic */ InlineParserFactory access$200(Builder r0) {
            return r0.getInlineParserFactory();
        }

        static /* synthetic */ List access$300(Builder r0) {
            return r0.postProcessors;
        }

        static /* synthetic */ List access$400(Builder r0) {
            return r0.delimiterProcessors;
        }

        static /* synthetic */ LinkReferenceChecker access$500(Builder r0) {
            return r0.linkReferenceChecker;
        }

        private InlineParserFactory getInlineParserFactory() {
            InlineParserFactory r0 = this.inlineParserFactory;
            if (r0 == null) goto L6;
            return r0;
        L6:
            return new AnonymousClass1(this);
        }

        public Parser build() {
            return new Parser(this, null);
        }

        public Builder customBlockParserFactory(BlockParserFactory r3) {
            BlockParserFactory r4 = (BlockParserFactory) ZeusTransformUtils.wrapperContextForParams(r3, BlockParserFactory.class, "com.obric.memorydata.plugin");
            Objects.requireNonNull(r4, "blockParserFactory must not be null");
            this.blockParserFactories.add(r4);
            return this;
        }

        public Builder customDelimiterProcessor(DelimiterProcessor r3) {
            DelimiterProcessor r4 = (DelimiterProcessor) ZeusTransformUtils.wrapperContextForParams(r3, DelimiterProcessor.class, "com.obric.memorydata.plugin");
            Objects.requireNonNull(r4, "delimiterProcessor must not be null");
            this.delimiterProcessors.add(r4);
            return this;
        }

        public Builder enabledBlockTypes(Set<Class<? extends Block>> r3) {
            Set<Class<? extends Block>> r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
            Objects.requireNonNull(r4, "enabledBlockTypes must not be null");
            this.enabledBlockTypes = r4;
            return this;
        }

        public Builder extensions(Iterable<? extends Extension> r4) {
            Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
            Objects.requireNonNull(r5, "extensions must not be null");
            Iterator r6 = r5.iterator();
        L4:
            if (r6.hasNext() == false) goto L8;
            Extension r0 = (Extension) ZeusTransformUtils.preCheckCast(r6.next(), Extension.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r0, ParserExtension.class) == false) goto L4;
            ((ParserExtension) ZeusTransformUtils.preCheckCast(r0, ParserExtension.class, "com.obric.memorydata.plugin")).extend(this);
            goto L4
        L8:
            return this;
        }

        public Builder inlineParserFactory(InlineParserFactory r3) {
            this.inlineParserFactory = (InlineParserFactory) ZeusTransformUtils.wrapperContextForParams(r3, InlineParserFactory.class, "com.obric.memorydata.plugin");
            return this;
        }

        public Builder postProcessor(PostProcessor r3) {
            PostProcessor r4 = (PostProcessor) ZeusTransformUtils.wrapperContextForParams(r3, PostProcessor.class, "com.obric.memorydata.plugin");
            Objects.requireNonNull(r4, "postProcessor must not be null");
            this.postProcessors.add(r4);
            return this;
        }
    }

    public interface LinkReferenceChecker {
        boolean enable(CharSequence r1);
    }

    public interface ParserExtension extends Extension {
        void extend(Builder r1);
    }

    private Parser(Builder r3) {
        this.blockParserFactories = DocumentParser.calculateBlockParserFactories(Builder.access$000(r3), Builder.access$100(r3));
        InlineParserFactory r0 = Builder.access$200(r3);
        this.inlineParserFactory = r0;
        this.postProcessors = Builder.access$300(r3);
        List<DelimiterProcessor> r1 = Builder.access$400(r3);
        this.delimiterProcessors = r1;
        this.linkReferenceChecker = Builder.access$500(r3);
        r0.create(new InlineParserContextImpl(r1, Collections.emptyMap()));
    }

    /* synthetic */ Parser(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    private DocumentParser createDocumentParser() {
        return new DocumentParser(this.blockParserFactories, this.inlineParserFactory, this.delimiterProcessors, this.linkReferenceChecker);
    }

    private Node postProcess(Node r4) {
        Iterator<PostProcessor> r3 = this.postProcessors.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r4 = ((PostProcessor) ZeusTransformUtils.preCheckCast(r3.next(), PostProcessor.class, "com.obric.memorydata.plugin")).process(r4);
        goto L4
    L6:
        return r4;
    }

    public Node parse(String r2) {
        Objects.requireNonNull(r2, "input must not be null");
        return postProcess(createDocumentParser().parse(r2));
    }
}
